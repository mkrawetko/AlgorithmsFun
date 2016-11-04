package com.mkrawetko;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int sum = 0;
        for (int i = 0; i < sArr.length; i++) {
            sum -= sArr[i];
            sum += tArr[i];
        }
        sum += tArr[tArr.length - 1];

        return (char) sum;
    }
}
