package com.mkrawetko.alg

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested

/*
Problem Scenario: Badge Access Control System
Imagine you are working on a security system that tracks employees entering and exiting a secure building using electronic badges.

You receive a list of records where each record contains:

Employee name (String)

Timestamp (Int, represented in minutes since midnight, e.g., 540 = 9:00 AM)

Action type: either "enter" or "exit" (String)

Here is your data class:

Kotlin
data class BadgeRecord(val name: String, val timestamp: Int, val action: String)
Part 1: Suspicious Entry / Exit Detection
Write a function that analyzes the logs and flags employees who performed an anomalous action sequence:

An employee enters the building twice without scanning out in between.

An employee exits the building without ever scanning in first.

Your function should return a collection (or list/set) of unique employee names who exhibited any suspicious behavior.
 */
class SuspiciousEntryExitDetectionTest {
    data class BadgeRecord(val name: String, val timestamp: Int, val action: String)


    @Test
    fun `should detect suspicious entry exit behavior`() {
        val logs = listOf(
            BadgeRecord("Alice", 540, "enter"),
            BadgeRecord("Bob", 550, "enter"),
            BadgeRecord("Alice", 560, "enter"), // Suspicious: Alice enters again without exiting
            BadgeRecord("Bob", 570, "exit"),
            BadgeRecord("Charlie", 580, "exit"), // Suspicious: Charlie exits without entering
            BadgeRecord("Alice", 590, "exit")
        )

        val suspiciousEmployees = detectSuspiciousBehavior(logs)

        assert(suspiciousEmployees.contains("Alice"))
        assert(suspiciousEmployees.contains("Charlie"))
        assert(!suspiciousEmployees.contains("Bob"))
    }

    private fun detectSuspiciousBehavior(logs: List<BadgeRecord>): Set<String> {

        val badgeRecordByUser = logs.groupBy(keySelector = BadgeRecord::name)

        val suspiciousEmployees = mutableSetOf<String>()
        badgeRecordByUser.forEach { (key, value) ->

            var previousRecord: String? = null
            for ((_, _, action) in value.sortedBy { it.timestamp }) {
                if (previousRecord == null && action == "exit") {
                    suspiciousEmployees += key
                    break
                } else if (previousRecord != action) {
                    previousRecord = action
                } else {
                    suspiciousEmployees += key
                    break
                }
            }
        }

        return suspiciousEmployees.toSet()
    }


    /*
    Part 2: High-Frequency Entry Detection (Sliding Window)
    Now, let's escalate to Part 2, which introduces time constraints.

    This is where Karat tests if you can handle intervals and sliding windows.

    The Problem:Update or write a new function to find all employees who entered the building 3 or more times within a 1-hour (60 minutes) window.
    Note: A "1-hour window" means the difference between the first and third entry timestamps in that window is <= 60 minutes.
    Return a set of unique employee names who triggered this threshold.
     */
    @Nested
    inner class HighFrequencyEntryDetectionTest {


        @Test
        fun `should detect high frequency entry behavior`() {
            val logs = listOf(
                BadgeRecord("Alice", 540, "enter"),
                BadgeRecord("Alice", 550, "enter"),
                BadgeRecord("Alice", 560, "enter"), // High frequency: Alice enters 3 times within 60 minutes
                BadgeRecord("Bob", 570, "enter"),
                BadgeRecord("Bob", 580, "enter"),
                BadgeRecord("Bob", 590, "enter"), // High frequency: Bob enters 3 times within 60 minutes
                BadgeRecord("Charlie", 600, "enter"),
                BadgeRecord("Charlie", 700, "enter"),
                BadgeRecord(
                    "Charlie",
                    800,
                    "enter"
                ) // Not high frequency: Charlie's entries are more than 60 minutes apart
            )

            val highFrequencyEmployees = detectHighFrequencyEntries(logs)

            Assertions.assertEquals(setOf("Alice", "Bob"), highFrequencyEmployees)

        }

        /*
        Complexity O(n
         */
        private fun detectHighFrequencyEntries(logs: List<BadgeRecord>): Set<String> {

            val recordsPerUser = logs.groupBy { it.name }

            val suspiciousEmployees = mutableSetOf<String>()
            recordsPerUser.forEach { (key, value) ->
                value.sortedBy { it.timestamp }.windowed(size = 3, step = 1).firstOrNull { window ->
                    window[2].timestamp - window[0].timestamp <= 60 && (window.count { it.action == "enter" } >= 3)
                }?.also {
                    suspiciousEmployees += key
                }
            }

            return suspiciousEmployees.toSet()
        }


        @Test
        fun `should detect high frequency entry behavior with exit in meantime`() {
            val logs = listOf(
                BadgeRecord("Alice", 540, "enter"),
                BadgeRecord("Alice", 550, "enter"),
                BadgeRecord("Alice", 560, "exit"),
                BadgeRecord("Alice", 570, "enter"), // High frequency: Alice enters 3 times within 60 minutes
                BadgeRecord("Bob", 570, "enter"),
                BadgeRecord("Bob", 580, "enter"),
                BadgeRecord("Bob", 590, "enter"), // High frequency: Bob enters 3 times within 60 minutes
                BadgeRecord("Charlie", 600, "enter"),
                BadgeRecord("Charlie", 700, "enter"),
                BadgeRecord(
                    "Charlie",
                    800,
                    "enter"
                ) // Not high frequency: Charlie's entries are more than 60 minutes apart
            )

            val highFrequencyEmployees = detectHighFrequencyEntries2(logs)

            Assertions.assertEquals(setOf("Alice", "Bob"), highFrequencyEmployees)

        }


        private fun detectHighFrequencyEntries2(logs: List<BadgeRecord>): Set<String> {

            val recordsPerUser = logs.groupBy { it.name }

            val suspiciousEmployees = mutableSetOf<String>()
            recordsPerUser.forEach { (key, value) ->
                value.sortedBy { it.timestamp }.windowed(size = 3, step = 1).firstOrNull { window ->
                    window[2].timestamp - window[0].timestamp <= 60 && (window.count { it.action == "enter" } >= 3)
                }?.also {
                    suspiciousEmployees += key
                }
            }

            return suspiciousEmployees.toSet()
        }
    }

}