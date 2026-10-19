package com.mkrawetko.alg

import org.junit.Test

class MatricesAndGrids_2DArraysTest {


    @Test
    fun `Safe Traversal Bounds Check`() {
        fun isValid(r: Int, c: Int, grid: Array<IntArray>): Boolean {
            return r in grid.indices && c in grid[0].indices
        }



    }

}