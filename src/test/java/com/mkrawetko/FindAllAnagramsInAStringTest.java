package com.mkrawetko;

import com.mkrawetko.support.Pair;
import com.mkrawetko.support.TestInput;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FindAllAnagramsInAStringTest {


    private final FindAllAnagramsInAString underTest = new FindAllAnagramsInAString();


    @TestFactory
    Stream<DynamicTest> findTheDifferenceTest() {

        return DynamicTest.stream(
                asList(
                        new TestInput<>(new Pair<>("abab", "ab"), asList(0, 1, 2)),
                        new TestInput<>(new Pair<>("cbaebabacd", "abc"), asList(0, 6))
                ).iterator(),
                TestInput::toString,
                (ti) -> assertEquals(ti.expected, underTest.findAnagrams(ti.input.first, ti.input.second))
        );
    }
}