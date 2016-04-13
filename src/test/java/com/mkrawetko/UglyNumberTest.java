package com.mkrawetko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class UglyNumberTest {


    @Parameterized.Parameter
    public int num;
    @Parameterized.Parameter(value = 1)
    public boolean expected;
    private UglyNumber underTest = new UglyNumber();


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, false},
                {1, true},
                {6, true},
                {7, false},
                {8, true},
                {11, false},
                {12, true},
                {14, false},
                {15, true},
                {-16, false},
                {17, false},
                {-99, false},
                {-1000, false},
                {1332185066, false},
                {1397794936, false},
                {-2147483648, false},
        });
    }


    @Test
    public void test() throws Exception {
        boolean actual = underTest.isUgly(num);

        assertThat(actual, equalTo(expected));

    }
}