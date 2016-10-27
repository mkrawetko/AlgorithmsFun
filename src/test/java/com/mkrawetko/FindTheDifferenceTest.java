package com.mkrawetko;

import com.mkrawetko.support.Pair;
import com.mkrawetko.support.TestInput;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given two strings s and t which consist of only lowercase letters.
 * <p>
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * <p>
 * Find the letter that was added in t.
 * <p>
 * Example:
 * <p>
 * Input:
 * s = "abcd"
 * t = "abcde"
 * <p>
 * Output:
 * e
 * <p>
 * Explanation:
 * 'e' is the letter that was added.
 */
public class FindTheDifferenceTest {


    private final FindTheDifference underTest = new FindTheDifference();


    @TestFactory
    Stream<DynamicTest> findTheDifferenceTest() {

        return DynamicTest.stream(asList(
                new TestInput<>(new Pair<>("abcd", "abcde"), "e")
                ).iterator(),
                (input) -> "input: " + input,
                (ti) -> assertEquals(ti.expected, underTest.findTheDifference(ti.input.first, ti.input.second))
        );
    }
}