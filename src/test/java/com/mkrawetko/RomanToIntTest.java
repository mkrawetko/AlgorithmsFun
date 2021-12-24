package com.mkrawetko;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

public class RomanToIntTest {

    RomanToInt underTest = new RomanToInt();

    public static Stream<Arguments> data() {
        return Stream.of(
                of("V", 5),
                of("II", 2),
                of("LVI", 56),
                of("IV", 4),
                of("III", 3),
                of("LVIII", 58),
                of("MCMXCIV", 1994),
                of("DCXXI", 621)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void shouldConvertRomanToInt(String romanStr, int expected) {
        int actual = underTest.romanToInt(romanStr);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void shouldConvertRomanToInt_backwards(String romanStr, int expected) {
        int actual = underTest.romanToInt_Backwards(romanStr);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void shouldConvertRomanToInt_recursive(String romanStr, int expected) {
        int actual = underTest.romanToInt_Recursive(romanStr);

        assertEquals(expected, actual);
    }
}