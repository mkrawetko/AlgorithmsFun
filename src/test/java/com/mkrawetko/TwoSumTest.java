package com.mkrawetko;

import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class TwoSumTest {


    @Parameterized.Parameter(value = 0)
    public int[] nums;
    @Parameterized.Parameter(value = 1)
    public int target;
    @Parameterized.Parameter(value = 2)
    public int expected;

    TwoSum underTest = new TwoSum();


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, 0},
                {new int[]{2, 3, 2}, 4},
                {new int[]{3, 5, 2, 1}, 6},
                {new int[]{3, 5, 2, 1, 4}, 9},
                {new int[]{5, 3, 2, 1, 4}, 11},
                {new int[]{2, 5, 8, 1, 3, 5}, 15},

        });
    }


    @org.junit.Test
    public void robTest() throws Exception {

        final int[] actual = underTest.twoSum(nums, target);

        assertThat(actual, equalTo(expected));
    }

//    @TestFactory
//    public Iterator<DynamicTest> testTwoSum() throws Exception {
//
//
//        return Arrays.asList(
//                dynamicTest("nums: {2, 7, 11, 15}; target: 9; expected {0,1}", () -> assertEquals(new int[]{0, 1}, underTest.twoSum(new int[]{2, 7, 11, 15}, 9)))
//        ).iterator();
//
//    }
}