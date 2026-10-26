package com.mkrawetko.alg

import java.math.BigDecimal

class SagaOrderProcessorTest {


}


data class OrderItem(val sku: String, val quantity: Int, val price: BigDecimal)
data class Order(
    val id: String,
    val customerId: String,
    val items: List<OrderItem>,
    val totalAmount: BigDecimal,
    val status: OrderStatus
)

enum class OrderStatus { CREATED, PROCESSING, COMPLETED, FAILED }

class OrderProcessor(
    private val paymentGateway: PaymentGateway,
    private val inventoryService: InventoryService,
    private val notificationClient: NotificationClient
) {
    suspend fun processOrder(order: Order): Result<Unit> {
        return try {
            if (order.status != OrderStatus.CREATED) {
                return Result.failure(IllegalStateException("Invalid order status: ${order.status}"))
            }

            // 1. Reserve inventory
            runCatching { inventoryService.reserveItems(order.items) }
                .getOrDefault(false).let { if (!it) return Result.failure(InventoryReservationFailedException(order)) }


            // 2. Charge payment
            runCatching { paymentGateway.charge(order.customerId, order.totalAmount) }
                .getOrDefault(false).let { if (!it) return Result.failure(ChargeFailedException(order)) }


            // 3. Notify customer
            runCatching { notificationClient.sendConfirmation(order.customerId, order.id) }
                .onFailure {
                    return Result.failure(ClientNotificationFailureException(order))
                }

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun processOrderWithCompensation(order: Order): Result<Unit> {
        val processOrderResult = processOrder(order)

        if (processOrderResult.isSuccess) {
            return processOrderResult
        }

        val exception =
            processOrderResult.exceptionOrNull() ?: RuntimeException("Unknown error during order processing")


        fun retryOrDLQ(action: () -> Unit) = repeat(3) { _ ->
            runCatching { action() }
                .onSuccess { return@repeat }
        }.run {
            // If all retries fail, send to DLQ
            println("Sending to DLQ: ${exception.message}")
        }


        when (exception) {
            is ChargeFailedException -> {
                // Compensate inventory reservation
//                retryOrDLQ { inventoryService.releaseItems(order.items) } // Assuming this method can also be used to release items
            }

            is InventoryReservationFailedException -> {
                // No compensation needed for inventory reservation failure
            }

            is ClientNotificationFailureException -> {
                // Retry notification
                retryOrDLQ { notificationClient.sendConfirmation(order.customerId, order.id) }
            }
        }

        return Result.failure(
            RuntimeException(
                "Order processing failed but it was compensated or sent to DLQ", exception
            )
        )
    }

    class ChargeFailedException(order: Order) : RuntimeException("Payment failed")
    class InventoryReservationFailedException(order: Order) : RuntimeException("Inventory reservation failed")
    class ClientNotificationFailureException(order: Order) : RuntimeException("Client Notification failed")

    interface NotificationClient {
        fun sendConfirmation(customerId: String, orderId: String) {
            TODO("Not yet implemented")
        }
    }

    interface InventoryService {
        fun reserveItems(items: List<OrderItem>): Boolean {
            TODO("Not yet implemented")
        }

    }

    interface PaymentGateway {
        fun charge(customerId: String, totalAmount: BigDecimal): Boolean {
            TODO("Not yet implemented")
        }

    }
}
