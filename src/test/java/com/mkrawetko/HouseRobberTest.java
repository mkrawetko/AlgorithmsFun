package com.mkrawetko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class HouseRobberTest {

    @Parameterized.Parameter(value = 0)
    public int[] nums;
    @Parameterized.Parameter(value = 1)
    public int expected;
    private HouseRobber underTest = new HouseRobber();


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

    @Test
    public void robTest() throws Exception {

        final int actual = underTest.rob(nums);

        assertThat(actual, equalTo(expected));
    }

}