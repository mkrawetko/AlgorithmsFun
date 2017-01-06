package com.mkrawetko;

import com.mkrawetko.support.Pair;
import com.mkrawetko.support.TestInput;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.time.Duration.ofSeconds;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;


public class FindAllAnagramsInAStringTest {


    private final FindAllAnagramsInAString underTest = new FindAllAnagramsInAString();
    private final TestInput<Pair<String, String>, List<Integer>> BIG_INPUT = readBigInput();


    private TestInput<Pair<String, String>, List<Integer>> readBigInput() {
        try {
            Path path = Paths.get(this.getClass().getClassLoader().getResource("FindAllAnagramsBigInput.txt").toURI());

            List<String> strings = Files.readAllLines(path);
            return new TestInput<>(new Pair<>(strings.get(0), strings.get(1)),
                    Stream.of(strings.get(2).split(","))
                            .map(Integer::valueOf)
                            .collect(toList()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @TestFactory
    Stream<DynamicTest> findTheDifferenceTest() {

        return DynamicTest.stream(
                asList(
                        new TestInput<>(new Pair<>("abab", "ab"), asList(0, 1, 2)),
                        new TestInput<>(new Pair<>("ababababab", "aab"), asList(0, 2, 4, 6)),
                        new TestInput<>(new Pair<>("cbaebabacd", "abc"), asList(0, 6)),
                        new TestInput<>(new Pair<>("af", "be"), Collections.emptyList()),
                        BIG_INPUT
                ).iterator(),
                TestInput::toString,
                (ti) -> assertTimeout(ofSeconds(1),
                        () -> assertEquals(ti.expected, underTest.findAnagrams(ti.input.first, ti.input.second)))
        );
    }
}