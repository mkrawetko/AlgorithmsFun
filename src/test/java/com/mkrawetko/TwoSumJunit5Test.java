package com.mkrawetko;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class TwoSumJunit5Test {


    private TwoSum underTest = new TwoSum();

    @TestFactory
    public Iterator<DynamicTest> testTwoSum() throws Exception {


        return Arrays.asList(
                dynamicTest("nums: {2, 7, 11, 15}; target: 9; expected {0,1}", () -> assertEquals(new int[]{0, 1}, underTest.twoSumArraySorted(new int[]{2, 7, 11, 15}, 9)))
        ).iterator();

    }
}