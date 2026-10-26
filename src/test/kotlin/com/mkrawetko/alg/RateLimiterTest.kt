package com.mkrawetko.alg


import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import kotlin.concurrent.atomics.AtomicLong
import kotlin.concurrent.atomics.ExperimentalAtomicApi
import kotlin.concurrent.atomics.incrementAndFetch

class RateLimiterTest {


    class RateLimiter(private val maxRequests: Long) {


        // Using native computeIfAbsent for strict thread-safety
        @OptIn(ExperimentalAtomicApi::class)
        private val requestCounts = ConcurrentHashMap<String, ConcurrentHashMap<Long, AtomicLong>>()

//        @OptIn(ExperimentalAtomicApi::class)
//        fun isAllowed(ipAddress: String, timestampInSeconds: Long): Boolean {
//            val currentBucket = timestampInSeconds / 60
//
//            // 1. Get or create the inner map atomically
//            @OptIn(ExperimentalAtomicApi::class)
//            val ipBuckets = requestCounts.computeIfAbsent(ipAddress) { ConcurrentHashMap() }
//
//            // 2. Get or create the counter atomically
//            @OptIn(ExperimentalAtomicApi::class)
//            val counter = ipBuckets.computeIfAbsent(currentBucket) { AtomicLong(0) }
//
//            // 3. Safely increment
//            @OptIn(ExperimentalAtomicApi::class)
//            val currentRequestCount = counter.incrementAndFetch()
//
//            return currentRequestCount <= maxRequests
//        }

        @OptIn(ExperimentalAtomicApi::class)
        fun isAllowed(ipAddress: String, timestampInSeconds: Long): Boolean {
            val currentBucket = timestampInSeconds / 60
//            synchronized(requestCounts) {
                val ipBuckets = requestCounts.computeIfAbsent(ipAddress) { ConcurrentHashMap() }
                val counter = ipBuckets.computeIfAbsent(currentBucket) { AtomicLong(0) }
                return counter.incrementAndFetch() <= maxRequests
//            }
        }


        @OptIn(ExperimentalAtomicApi::class)
        fun cleanupOldData(currentTimestampInSeconds: Long) {
            val currentBucket = System.currentTimeMillis() / 1000 / 60

            val ipIterator = requestCounts.iterator()

            while(ipIterator.hasNext()){
                val (ip:String,buckets:ConcurrentMap<Long,AtomicLong>) = ipIterator.next()

                val bucketsIterator = buckets.iterator()

                while(bucketsIterator.hasNext()){
                    val (bucket,_) = bucketsIterator.next()
                    if(bucket<currentBucket){
                        bucketsIterator.remove()
                    }
                }

                if(buckets.isEmpty()) {
                    requestCounts.compute(ip){ _, existingBuckets ->
                        if(existingBuckets!!.isEmpty()) null else existingBuckets
                    }
                }

            }
        }
    }


    @Test
    fun `test rate limiter`() {
        val rateLimiter = RateLimiter(maxRequests = 5)

        val ipAddress = "192.168.1.1"

        repeat(5) { timestamp ->
            Assertions.assertTrue(rateLimiter.isAllowed(ipAddress, timestamp.toLong()))
        }

        Assertions.assertFalse(rateLimiter.isAllowed(ipAddress, 6))
    }
}