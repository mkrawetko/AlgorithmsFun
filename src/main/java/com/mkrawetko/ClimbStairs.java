package com.mkrawetko;

public class ClimbStairs {


    int[] memory = new int[1000];

    public ClimbStairs() {
        memory[1] = 1;
        memory[2] = 2;
        memory[3] = 3;
        for (int i = 4; i < memory.length; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
    }

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * tags: DynamicProgramming
     */
    public int climbStairs(int n) {
        return memory[n];
    }
}
