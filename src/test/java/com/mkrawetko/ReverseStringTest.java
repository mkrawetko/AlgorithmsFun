package com.mkrawetko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ReverseStringTest {
    @Parameterized.Parameter(value = 0)
    public String str;
    @Parameterized.Parameter(value = 1)
    public String expected;

    ReverseString underTest = new ReverseString();


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"hello", "olleh"}
        });
    }

    @Test
    public void test() {

        String actual = underTest.reverseString(str);

        assertThat(actual, equalTo(expected));
    }


}