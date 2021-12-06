package com.mkrawetko;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Integer.parseUnsignedInt;
import static org.junit.jupiter.params.provider.Arguments.of;

public class NumberOf1BitsTest {

    private final NumberOf1Bits underTest = new NumberOf1Bits();


    public static Stream<Arguments> data() {
        return Stream.of(
                of(1, 1),  //0001
                of(2, 1),  //0010
                of(3, 2),  //0011
                of(4, 1),  //0100
                of(5, 2),  //0101
                of(6, 2),  //0110
                of(7, 3),  //0111
                of(8, 1),  //1000
                of(11, 3), //1011
                of(parseUnsignedInt("00000000000000000000000010000000", 2), 1), //00000000000000000000000010000000
                of(parseUnsignedInt("11111111111111111111111111111101", 2), 31),
                of(parseUnsignedInt("10000000000000000000000000000000", 2), 1)
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    public void test(int unsignedInteger, int expected) throws Exception {
        int actual = underTest.hammingWeight(unsignedInteger);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void shouldReturnNumberOfBits_recursive(int unsignedInteger, int expected) {
        int actual = underTest.hammingWeightRecursive(unsignedInteger);

        Assertions.assertEquals(expected, actual);
    }
}