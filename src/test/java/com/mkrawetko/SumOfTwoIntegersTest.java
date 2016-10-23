package com.mkrawetko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(Parameterized.class)
public class SumOfTwoIntegersTest {
    @Parameterized.Parameter(value = 0)
    public int a;
    @Parameterized.Parameter(value = 1)
    public int b;
    @Parameterized.Parameter(value = 2)
    public int expected;

    SumOfTwoIntegers underTest = new SumOfTwoIntegers();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3},
                {1, 3, 4},
                {5, 4, 9},
        });
    }

    @Test
    public void test() {

        int actual = underTest.getSum(a, b);

        assertThat(actual, equalTo(expected));
    }
}