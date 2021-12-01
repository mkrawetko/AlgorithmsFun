package com.mkrawetko;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class ClimbStairsTest {

    final ClimbStairs underTest = new ClimbStairs();

    public static Stream<Arguments> data() {
        return Stream.of(of(1, 1),
                of(1, 1),
                of(2, 2),
                of(3, 3),
                of(4, 5),
                of(5, 8),
                of(6, 13),
                of(7, 21),
                of(8, 34)
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    public void climbStairsIterativeTmp(int steps, int expected) {
        int actual = underTest.climbStairsIterativeTmp(steps);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void climbStairsRecursive(int steps, int expected) {
        int actual = underTest.climbStairsRecursive(steps);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void climbStairsIterativeWithCache(int steps, int expected) {
        int actual = underTest.climbStairsIterativeWithCache(steps);

        assertEquals(expected, actual);
    }
}