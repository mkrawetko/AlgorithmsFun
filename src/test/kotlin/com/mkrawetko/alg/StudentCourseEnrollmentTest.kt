package com.mkrawetko.alg

import org.junit.Test
import org.junit.jupiter.api.Assertions

class StudentCourseEnrollmentTest {

    data class Enrollment(val student: String, val course: String)

    /*
    Part 1: Find All Pairs of Students Who Share a Course
Write a function that takes a list of Enrollment records and returns a map or collection showing all pairs of students who share at least one common course.

Requirement: Each pair should be listed as a sorted or unique combination (e.g., if Alice and Bob share a course, include ("Alice", "Bob") or ("Bob", "Alice"), but avoid duplicate reverse pairs).

Give it a try in Kotlin! Write your implementation and paste it here whenever you're ready, and we'll break down the logic and complexity together.
     */
    @Test
    fun `should find all pairs of students who share a course`() {
        val enrollments = listOf(
            Enrollment("Alice", "Math"),
            Enrollment("Bob", "Math"),
            Enrollment("Alice", "Science"),
            Enrollment("Charlie", "Science"),
            Enrollment("Bob", "History"),
            Enrollment("Charlie", "History"),
            Enrollment("Charlie", "Math"),
            Enrollment("Kate", "Math"),
        )

        val pairs = findStudentPairs(enrollments)

        println(pairs) // Expected output: [("Alice", "Bob"), ("Alice", "Charlie"), ("Bob", "Charlie")]
        Assertions.assertEquals(setOf(
            setOf("Alice", "Bob"),
            setOf("Alice", "Charlie"),
            setOf("Alice", "Kate"),
            setOf("Bob", "Charlie"),
            setOf("Bob", "Kate"),
            setOf("Charlie", "Kate")
        ), pairs)
    }

    private fun findStudentPairs(enrollments: List<Enrollment>):Set<Set<String>> {
        val courseByStudent = enrollments.groupBy(keySelector = Enrollment::student, valueTransform = Enrollment::course)
        val studentsByCourse = enrollments.groupBy(keySelector = Enrollment::course, valueTransform = Enrollment::student)

        val pairs = mutableSetOf<Set<String>>()
        courseByStudent.forEach { (student, courses) ->
            courses.forEach { course ->
                val coursePairs = studentsByCourse[course]!!.filter{it!=student}.map{setOf(student,it)}.toSet()
                pairs.addAll(coursePairs)
            }
        }

        return pairs

    }


}