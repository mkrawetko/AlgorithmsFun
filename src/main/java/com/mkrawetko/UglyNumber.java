package com.mkrawetko;

/**
 * Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {

//    private static final LinkedList<Integer> primes = new LinkedList<>(Arrays.asList(7));

    public boolean isUgly(int num) {

        if (num <= 0) {
            return false;
        }

        if (num == 7) {
            return false;
        }
        if (num < 11) {
            return true;
        }

        boolean isUglyCandidate = num % 2 == 0 || num % 3 == 0 || num % 5 == 0;
        if (!isUglyCandidate) {
            return false;
        }


        int maxPrimeFactor = (int) Math.ceil(Math.sqrt(num)) + 1;
//        int maxPrimeFactor = num/2+1;

        int primeFactor = -1;

        int nextPrime = 2;

        while (maxPrimeFactor >= nextPrime) {
            if (num % nextPrime == 0) {
                primeFactor = nextPrime;
                if (primeFactor > 5) {
                    return false;
                } else {
                    num = num / primeFactor;
                    maxPrimeFactor = (int) Math.ceil(Math.sqrt(num));
                    nextPrime = 2;
//                    primeFactor = -1;
                }
            }
            nextPrime = getNextPrime(nextPrime);
        }
        return primeFactor < 0 && num > 5 ? false : true;
    }

    private int getNextPrime(int base) {
        final int step = 2;
        int nextCandidate = base + step;
        while (nextCandidate % 3 == 0) {
            nextCandidate += step;
        }
        return nextCandidate;
    }
}
