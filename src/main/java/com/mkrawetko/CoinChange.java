package com.mkrawetko;

import java.util.Arrays;

public class CoinChange {

    int minCount = Integer.MAX_VALUE;

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

        count(coins, coins.length - 1, amount, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private void count(final int[] coins, final int idx, int amount, int stepCount) {
        if (amount % coins[idx] == 0) {
            int newCount = stepCount + (amount / coins[idx]);
            minCount = Math.min(newCount, minCount);
        }

        if (idx == 0) {
            return;
        }

        for (int i = amount / coins[idx]; i >= 0; i--) {

            final int newAmount = amount - i * coins[idx];
            final int newCount = stepCount + i;
            if (newAmount == 0) {
                minCount = Math.min(minCount, newCount);
                return;
            }

            if (newAmount <= 0 || newCount + 1 >= minCount) {
                break;
            }

            count(coins, idx - 1, newAmount, newCount);

        }

    }
}
