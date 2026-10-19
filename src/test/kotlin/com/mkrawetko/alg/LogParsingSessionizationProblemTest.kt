package com.mkrawetko.alg

import org.junit.Test
import org.junit.jupiter.api.Assertions

/*
Scenario:
 Given a list of server access logs [timestamp, username, resource],
 find each user's earliest and latest access time,
 and return the user with the longest total session duration.
 */
class LogParsingSessionizationProblemTest {


    data class LogEntry(val timestamp: Int, val user: String, val resource: String)

//    fun findLongestSessionUser(logs: List<LogEntry>): Pair<String, Int> {
//
//        val logsPerUser = logs.groupBy(
//            keySelector = LogEntry::user,
//            valueTransform = LogEntry::timestamp
//        )
//
//        val sessionDurationPerUser = logsPerUser.mapValues{
//            it.value.max() - it.value.min()
//        }
//
//        val userWithLongestSession = sessionDurationPerUser.maxBy { it.value }
//
//        return userWithLongestSession.toPair();
//    }



    fun findLongestSessionUser(logs: List<LogEntry>): Pair<String, Int> {

        val minTimestampPerUser = mutableMapOf<String, Int>()
        val maxTimestampPerUser = mutableMapOf<String, Int>()


        logs.forEach {
            minTimestampPerUser[it.user] = minOf(minTimestampPerUser[it.user]?:it.timestamp,it.timestamp)
            maxTimestampPerUser[it.user] = maxOf(maxTimestampPerUser[it.user]?:it.timestamp,it.timestamp)
        }

        var longestSessionUser = "" to 0
        for (user in minTimestampPerUser.keys) {
            val newLongestSessionUser = maxTimestampPerUser[user]!! - minTimestampPerUser[user]!!
            if(newLongestSessionUser>=longestSessionUser.second){
                longestSessionUser = user to newLongestSessionUser
            }
        }
        return longestSessionUser
    }



    @Test
    fun `should return user with longest session`(){
        val u1 = LogEntry(1, "user1", "/home")
        val u2 = LogEntry(7, "user1", "/profile")
        val u3 = LogEntry(2, "user2", "/home")
        val u4 = LogEntry(6, "user2", "/profile")
        val u5 = LogEntry(6, "user5", "/profile3")

        val actualUserWithLongestTotalSessionDuration = findLongestSessionUser(listOf(u1, u2, u3, u4,u5))
        Assertions.assertEquals("user1" to 6, actualUserWithLongestTotalSessionDuration)
    }

    @Test
    fun `should return user with longest session when only 1 user log`(){
        val u5 = LogEntry(6, "user5", "/profile3")

        val actualUserWithLongestTotalSessionDuration = findLongestSessionUser(listOf(u5))
        Assertions.assertEquals("user5" to 0, actualUserWithLongestTotalSessionDuration)
    }
    @Test
    fun `should return user with longest session when only 2 users log`(){
        val u1 = LogEntry(3, "user1", "/profile1")
        val u5 = LogEntry(6, "user5", "/profile3")

        val actualUserWithLongestTotalSessionDuration = findLongestSessionUser(listOf(u5))
        Assertions.assertEquals("user5" to 0, actualUserWithLongestTotalSessionDuration)
    }


}