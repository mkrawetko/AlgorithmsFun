package com.mkrawetko.alg


import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.time.Instant

data class WebhookEvent(val eventId: String, val payload: String, val timestamp: Instant)

class WebhookProcessor(
    private val auditLogClient: AuditLogClient,
    private val paymentProcessor: PaymentProcessor
) {

    private val mutexForEvent = java.util.concurrent.ConcurrentHashMap<String, Mutex>()
    // Simple in-memory cache to prevent duplicate processing
    private val processedEvents = java.util.concurrent.ConcurrentHashMap<String, Boolean>()

    suspend fun handleEvent(event: WebhookEvent): Result<Unit> = coroutineScope {

        val mutex = mutexForEvent.computeIfAbsent(event.eventId) { Mutex() }

         mutex.withLock {
            // 1. Check if already processed
            if (processedEvents[event.eventId] == true) {
                return@coroutineScope Result.success(Unit)
            }

            // 2. Process the payment payload
            val success = paymentProcessor.execute(event.payload)

            if (success) {
                auditLogClient.record(event.eventId)
                // 3. Mark as processed
                processedEvents[event.eventId] = true
                Result.success(Unit)
            } else {
                Result.failure(RuntimeException("Payment execution failed"))
            }
        }
    }
}

interface PaymentProcessor {
    fun execute(payload: String): Boolean
}

interface AuditLogClient {
    fun record(eventId: String)
}
