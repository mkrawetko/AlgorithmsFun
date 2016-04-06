package com.mkrawetko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CoinChangeTest {
    @Parameter(value = 0)
    public int[] coins;
    @Parameter(value = 1)
    public int amount;
    @Parameter(value = 2)
    public int expected;

    private CoinChange underTest = new CoinChange();

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1}, 0, 0},
                {new int[]{2}, 3, -1},
                {new int[]{5}, 10, 2},
                {new int[]{1, 2, 5}, 11, 3},
                {new int[]{2, 5, 10, 1}, 27, 4},
                {new int[]{2, 4, 5}, 13, 3},
                {new int[]{3, 4, 7}, 17, 3},
                {new int[]{186, 419, 83, 408}, 6249, 20},
                {new int[]{288, 160, 10, 249, 40, 77, 314, 429}, 9208, 22}

        });
    }

    @Test
    public void coinChange() throws Exception {

        final int actual = underTest.coinChange(coins, amount);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void coinChangeRecursive() throws Exception {

        final int actual = underTest.coinChangeRecursive(coins, amount);

        assertThat(actual, equalTo(expected));
    }


}