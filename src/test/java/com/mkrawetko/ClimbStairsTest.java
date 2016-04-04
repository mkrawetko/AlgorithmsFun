package com.mkrawetko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ClimbStairsTest {

    final ClimbStairs underTest = new ClimbStairs();
    @Parameterized.Parameter
    public int steps;
    @Parameterized.Parameter(value = 1)
    public int expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 5},
                {5, 8},
                {6, 13},
                {7, 21},
                {8, 34},
        });
    }

    @Test
    public void climbStairs() throws Exception {
        int actual = underTest.climbStairs(steps);

        assertThat(actual, equalTo(expected));

    }
}