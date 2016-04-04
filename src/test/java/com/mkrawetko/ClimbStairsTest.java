package com.mkrawetko;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ClimbStairsTest {

    final ClimbStairs underTest = new ClimbStairs();

    @Test
    public void climbStairs() throws Exception {
        assertThat(underTest.climbStairs(1), equalTo(1));
        assertThat(underTest.climbStairs(2), equalTo(2));
        assertThat(underTest.climbStairs(3), equalTo(3));
        assertThat(underTest.climbStairs(4), equalTo(5));
        assertThat(underTest.climbStairs(5), equalTo(8));
        assertThat(underTest.climbStairs(6), equalTo(13));
        assertThat(underTest.climbStairs(7), equalTo(21));
        assertThat(underTest.climbStairs(8), equalTo(34));
    }
}