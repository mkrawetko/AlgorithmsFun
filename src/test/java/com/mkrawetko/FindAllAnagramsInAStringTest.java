package com.mkrawetko;

import com.mkrawetko.support.Pair;
import com.mkrawetko.support.TestInput;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
                        new TestInput<>(new Pair<>("cbaebabacd", "abc"), asList(0, 6)),
                        BIG_INPUT
                ).iterator(),
                TestInput::toString,
                (ti) -> assertEquals(ti.expected, underTest.findAnagrams(ti.input.first, ti.input.second))
        );
    }
}