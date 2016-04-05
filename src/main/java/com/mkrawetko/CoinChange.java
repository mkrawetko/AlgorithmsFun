package com.mkrawetko;

import java.util.Arrays;

public class CoinChange {

    /**
     * You are given coins of different denominations and a total amount of money amount.
     * Write a function to compute the fewest number of coins that you need to make up that amount.
     * If that amount of money cannot be made up by any combination of the coins, return -1.
     * <p>
     * Example 1:
     * coins = [1, 2, 5], amount = 11
     * return 3 (11 = 5 + 5 + 1)
     * <p>
     * Example 2:
     * coins = [2], amount = 3
     * return -1.
     * <p>
     * Note:
     * You may assume that you have an infinite number of each kind of coin.
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length <= 0 || amount == 0) {
            return amount == 0 ? 0 : -1;
        }
        Arrays.sort(coins);
        int[] min = new int[amount + 1];
        for (int i = coins[0]; i <= amount; i++) {

            for (int coin : coins) {
                if (coin <= i) {
                    int prevIdx = i - coin;
                    int prevSolution = min[prevIdx];
                    if (prevIdx == 0 || (prevSolution != 0 && (min[i] == 0 || prevSolution + 1 < min[i]))) {
                        min[i] = prevSolution + 1;
                    }
                }
            }
        }
        return min[amount] != 0 ? min[amount] : -1;
    }

    public int coinChangeRecursive(int[] coins, int amount) {
        if (coins.length <= 0 || amount == 0) {
            return amount == 0 ? 0 : -1;
        }
        Arrays.sort(coins);

        int minCount = count(coins, coins.length - 1, amount, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private int count(final int[] coins, final int idx, int amount, int stepCount) {
        int bestCount = Integer.MAX_VALUE;
        if (amount % coins[idx] == 0) {
            int newCount = stepCount + (amount / coins[idx]);
            bestCount = Math.max(newCount, bestCount);
        }
        amount -= coins[idx];
        stepCount++;
        if (amount == 0) {
            return stepCount;
        }
        if (amount < coins[idx]) {
            return Integer.MAX_VALUE;
        }

        for (int i = coins.length - 1; i >= 0; i--) {


            if (bestCount < stepCount + 1) {
                break;
            }
            bestCount = Math.min(count(coins, i, amount, stepCount), bestCount);


        }
        return bestCount;

    }
}
