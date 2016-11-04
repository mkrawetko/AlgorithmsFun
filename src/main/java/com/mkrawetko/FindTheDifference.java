package com.mkrawetko;

import java.util.Arrays;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {

        char[] sSorted = s.toCharArray();
        Arrays.sort(sSorted);

        char[] tSorted = t.toCharArray();
        Arrays.sort(tSorted);

        for (int i = 0; i < s.length(); i++) {
            if (sSorted[i] != tSorted[i]) {
                return tSorted[i];
            }
        }

        return tSorted[t.length() - 1];
    }
}
