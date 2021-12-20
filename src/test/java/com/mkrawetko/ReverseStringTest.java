package com.mkrawetko;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class ReverseStringTest {

    ReverseString underTest = new ReverseString();

    public static Stream<Arguments> data() {
        return Stream.of(of("hello", "olleh"),
                of("Hannah", "hannaH"));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test(String str, String expected) {
        String actual = underTest.reverseString(str);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test_recursive(String str, String expected) {
        String actual = underTest.reverseStringRecursive(str);

        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("data")
    public void shouldRevertStringSubString(String str, String expected) {
        String actual = underTest.reverseStringSubString(str);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void shouldRevertStringSubStringRecursive(String str, String expected) {
        String actual = underTest.reverseStringSubStringRecursive(str);

        assertEquals(expected, actual);
    }


}