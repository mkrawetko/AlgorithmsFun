package com.mkrawetko.alg

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.time.Duration.Companion.milliseconds

class ConcurrencyAndCoroutinesTest {


    @Test
    fun `check concurrency`(): Unit = runBlocking {
        val job = launch {
            delay(1000.milliseconds)
            println("doneLaunch");
        }

        job.join()
    }

    @Test
    fun `check async`(): Unit = runBlocking {

        val deferred = async {
            delay(1000.milliseconds)
            "doneAsync"
        }

        println(deferred.await())
    }

}