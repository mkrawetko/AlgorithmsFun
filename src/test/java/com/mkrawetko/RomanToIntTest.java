package com.mkrawetko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RomanToIntTest {

    @Parameterized.Parameter(value = 0)
    public String romanStr;
    @Parameterized.Parameter(value = 1)
    public int expected;

    RomanToInt underTest = new RomanToInt();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"IV", 4},
                {"DCXXI", 621},
        });
    }

    @Test
    public void test() {

        int actual = underTest.romanToInt(romanStr);

        assertThat(actual, equalTo(expected));
    }
}