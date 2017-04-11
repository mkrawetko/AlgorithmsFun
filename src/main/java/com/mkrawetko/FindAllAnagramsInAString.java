package com.mkrawetko;


import java.util.LinkedList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        final List<Integer> anagrams = new LinkedList<>();

        int[] hash = new int[129];
        for (int c : p.toCharArray()) {
            hash[c]++;
        }
        int left = 0, right = 0;
        while (s.length() > right) {

            if (--hash[s.charAt(right++)] < 0) {
                while (hash[s.charAt(right - 1)] < 0) {
                    hash[s.charAt(left++)]++;
                }
            }

            if (right - left == p.length()) {
                anagrams.add(left);
                hash[s.charAt(left++)]++;
            }
        }

        return anagrams;
    }


}
