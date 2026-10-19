package com.mkrawetko.alg

import org.junit.Test
import org.junit.jupiter.api.Assertions


/*
An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.

Example 1:

Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.


Example 2:

Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
Output: false
Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
Hence, we return false.
Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
1 <= matrix[i][j] <= n
 */
class CheckifEveryRowAndColumnContainsAllNumbersTest {


    @Test
    fun `should check if every row and column contains all numbers`() {
        fun checkValid(matrix: Array<IntArray>): Boolean {
            val expectedSet = (1..matrix.size).toSet()
            return matrix.indices.none { row ->
                matrix[row].toSet() != expectedSet ||
                        matrix.indices.map { column ->
                            matrix[column][row]
                        }.toSet() != expectedSet
            }
        }


        val matrix1 = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 1, 2),
            intArrayOf(2, 3, 1)
        )
        Assertions.assertTrue{ checkValid(matrix1) }
//
        val matrix2 = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 2, 3),
            intArrayOf(1, 2, 3)
        )
        Assertions.assertFalse{ checkValid(matrix2) }

        val matrix3 = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 1, 2),
            intArrayOf(1, 3, 2)
        )
        Assertions.assertFalse{ checkValid(matrix3) }
    }


}