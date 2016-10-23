package com.mkrawetko;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int and = a & b;
        int xor = a ^ b;
        if (and == 0) {
            return xor;
        }
        return getSum(and << 1, xor);
    }
}

