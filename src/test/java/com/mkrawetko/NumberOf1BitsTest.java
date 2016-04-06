package com.mkrawetko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class NumberOf1BitsTest {


    @Parameterized.Parameter
    public int unsignedInteger;
    @Parameterized.Parameter(value = 1)
    public int expected;
    private NumberOf1Bits underTest = new NumberOf1Bits();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},  //0001
                {2, 1},  //0010
                {3, 2},  //0011
                {4, 1},  //0100
                {5, 2},  //0101
                {6, 2},  //0110
                {7, 3},  //0111
                {8, 1},  //1000
                {11, 3}, //1011
        });
    }


    @Test
    public void test() throws Exception {
        int actual = underTest.hammingWeight(unsignedInteger);

        assertThat(actual, equalTo(expected));

    }
}