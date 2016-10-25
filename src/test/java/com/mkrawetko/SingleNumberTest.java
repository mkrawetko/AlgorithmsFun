package com.mkrawetko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
@RunWith(Parameterized.class)
public class SingleNumberTest {

    @Parameterized.Parameter(value = 0)
    public int[] nums;
    @Parameterized.Parameter(value = 1)
    public int expected;

    SingleNumber underTest = new SingleNumber();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1}, 1},
                {new int[]{1, 1, 2, 3, 3}, 2},
                {new int[]{1, 1, 3, 3, 2}, 2},
        });
    }

    @Test
    public void test() {

        int actual = underTest.singleNumber(nums);

        assertThat(actual, equalTo(expected));
    }
}
