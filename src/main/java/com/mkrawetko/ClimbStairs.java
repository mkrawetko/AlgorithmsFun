package com.mkrawetko;

public class ClimbStairs {


    /**
     * https://leetcode.com/problems/climbing-stairs/
     * You are climbing a staircase. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * tags: DynamicProgramming
     * Example 1:
     * <p>
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * <p>
     * Example 2:
     * <p>
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1-step
     * <p>
     * Hint: To reach nth step, what could have been your previous steps? (Think about the step sizes)
     */
    public ClimbStairs() {
    }

    public int climbStairsIterativeWithCache(int top) {
        int[] cache = new int[top + 1];
        cache[0] = 1;
        cache[1] = 2;
        for (int i = 2; i <= top; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[top - 1];
    }

    public int climbStairsIterativeTmp(int top) {
        if (top <= 2) return top;
        int cur = 2, prev = 1;
        for (int i = 3; i <= top; i++) {
            int tmp = cur;
            cur = cur + prev;
            prev = tmp;
        }
        return cur;
    }

    public int climbStairsRecursive(int top) {
        if (top <= 2) return top;
        return climbStairsRecursive(top - 1) + climbStairsRecursive(top - 2);
    }

}
