package com.mkrawetko;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class TwoSumTest {


    public static final int[] BIG_ARRAY = readBigArray();
    @Parameterized.Parameter(value = 0)
    public int[] nums;
    @Parameterized.Parameter(value = 1)
    public int target;
    @Parameterized.Parameter(value = 2)
    public int[] expected;
    TwoSum underTest = new TwoSum();

    private static int[] readBigArray() {
        try {
            Path path = Paths.get(TwoSumTest.class.getClassLoader().getResource("TwoSumBigArray.txt").toURI());

            return Files.lines(path).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new int[0];
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}}

                        , {new int[]{11, 2, 15, 7}, 9, new int[]{1, 3}}

                        , {new int[]{3, 2, 4}, 6, new int[]{1, 2}}

                        , {new int[]{-1, -2, -3, -4, -5}, -8, new int[]{2, 4}}

                        , {new int[]{-3, 4, 3, 90}, 0, new int[]{0, 2}}

                        , {new int[]{0, 4, 3, 0}, 0, new int[]{0, 3}}

                        , {BIG_ARRAY, 16021, new int[]{8010, 8011}}
                }
        );
    }


    @org.junit.Test
    public void testTwoSumSortedArray() throws Exception {

        final int[] actual = underTest.twoSumArraySorted(nums, target);

        assertThat(actual, equalTo(expected));
    }

    @org.junit.Test
    public void testTwoSumHashMap() throws Exception {

        final int[] actual = underTest.twoSumHashMap(nums, target);

        assertThat(actual, equalTo(expected));
    }
}