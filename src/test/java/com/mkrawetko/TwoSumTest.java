package com.mkrawetko;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class TwoSumTest {


    @Parameterized.Parameter(value = 0)
    public int[] nums;
    @Parameterized.Parameter(value = 1)
    public int target;
    @Parameterized.Parameter(value = 2)
    public int[] expected;

    TwoSum underTest = new TwoSum();


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
//                {new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}},
//                {new int[]{11, 2, 15, 7}, 9, new int[]{1, 3}},
                {new int[]{3, 2, 4}, 6, new int[]{1, 2}}
        });
    }


    @org.junit.Test
    public void testTwoSum() throws Exception {

        final int[] actual = underTest.twoSum(nums, target);

        assertThat(actual, equalTo(expected));
    }
}