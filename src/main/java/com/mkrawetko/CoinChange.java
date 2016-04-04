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
        int[] min = new int[amount + 1];
        Arrays.sort(coins);
        for (int i = coins[0]; i <= amount; i++) {

            for (int coin : coins) {
                if (coin <= i) {
                    int prevIdx = i - coin;
                    if (prevIdx == 0 || (min[prevIdx] != 0 && (min[i] == 0 || min[prevIdx] + 1 < min[i]))) {
                        min[i] = min[prevIdx] + 1;
                    }
                }
            }
        }
        return min[amount] != 0 ? min[amount] : -1;
    }

}
