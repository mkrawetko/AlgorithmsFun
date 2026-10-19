package com.mkrawetko.alg

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CollectionsAndAggregationsTest {


    @Test
    fun `should Create Frequency Map`(){

        val actual = "karat".groupingBy { it }.eachCount()

        val expected = mapOf(
            'k' to 1,
            'a' to 2,
            'r' to 1,
            't' to 1
        )
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should groupBy logs by userId`(){

        data class Log(val userId:String, val log: String)

        val logs = listOf(
            Log("user1", "user1Log1"),
            Log("user2", "user2Log1"),
            Log("user1", "user1Log2"),
            Log("user3", "user3Log1"),
        )

//        val actual = logs
//            .groupBy{it.userId}
//            .mapValues { (_,logs) -> logs.map { it.log } }

        val actual = logs
            .groupBy(keySelector = Log::userId,
                valueTransform = Log::log)


        Assertions.assertEquals(mapOf(
            "user1" to listOf("user1Log1", "user1Log2"),
            "user2" to listOf("user2Log1"),
            "user3" to listOf("user3Log1"),
        ), actual)
    }

    @Test
    fun `should associate logs by userId`(){

        data class Log(val userId:String, val log: String)

        val logs = listOf(
            Log("user1", "user1Log1"),
            Log("user2", "user2Log1"),
            Log("user1", "user1Log2"),
            Log("user3", "user3Log1"),
        )

//        val actual = logs
//            .groupBy{it.userId}
//            .mapValues { (_,logs) -> logs.map { it.log } }

        val actual = logs
            .associateBy(keySelector = Log::userId,
                valueTransform = Log::log)


        Assertions.assertEquals(mapOf(
            "user1" to "user1Log2",
            "user2" to "user2Log1",
            "user3" to "user3Log1",
        ), actual)
    }

    @Test
    fun `should use window`(){
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val actual = numbers.windowed(size = 3, step = 3)


        Assertions.assertEquals(listOf(listOf(1,2,3),listOf(4,5,6),listOf(7,8,9)), actual)
    }
}