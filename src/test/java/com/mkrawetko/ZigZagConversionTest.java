package com.mkrawetko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ZigZagConversionTest {


    @Parameterized.Parameter
    public String s;
    @Parameterized.Parameter(value = 1)
    public int numsRows;
    @Parameterized.Parameter(value = 2)
    public String expected;
    private ZigZagConversion underTest = new ZigZagConversion();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", 1, ""}
                , {"PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"}
                , {"PAYPALISHIRING", 4, "PINALSIGYAHRPI"}
                , {"ABC", 2, "ACB"}
                , {"ABCDE", 4, "ABCED"}
        });
    }

    @Test
    public void test() throws Exception {
        String actual = underTest.convert(s, numsRows);

        assertThat(actual, equalTo(expected));

    }
}