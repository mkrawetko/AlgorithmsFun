package com.mkrawetko;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class TwoSumTest {

    private static final int[] BIG_ARRAY = readBigArray();
    private TwoSum underTest = new TwoSum();

    private static int[] readBigArray() {
        try {
            Path path = Paths.get(TwoSumTest.class.getClassLoader().getResource("TwoSumBigArray.txt").toURI());

            return Files.lines(path).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new int[0];
    }

    private static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                of(new int[]{11, 2, 15, 7}, 9, new int[]{1, 3}),
                of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                of(new int[]{-1, -2, -3, -4, -5}, -8, new int[]{2, 4}),
                of(new int[]{-3, 4, 3, 90}, 0, new int[]{0, 2}),
                of(new int[]{0, 4, 3, 0}, 0, new int[]{0, 3}),
                of(BIG_ARRAY, 16021, new int[]{8010, 8011})
        );
    }


    @ParameterizedTest(name = "({0}, {1}) expected: {2}")
    @MethodSource("argumentsProvider")
    void testTwoSumSortedArray(int[] nums, int target, int[] expected) {
        assertArrayEquals(expected, underTest.twoSumArraySorted(nums, target));
    }

    @ParameterizedTest(name = "({0}, {1}) expected: {2}")
    @MethodSource("argumentsProvider")
    void testTwoSumHashMap(int[] nums, int target, int[] expected) {
        assertArrayEquals(expected, underTest.twoSumHashMap(nums, target));
    }
}