package com.mkrawetko;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

        Set<Character> pSet = new HashSet<>();
        char[] pChars = p.toCharArray();
        int psum = 0;
        for (char c : pChars) {
            psum += c;
            pSet.add(c);
        }

        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length - pChars.length + 1; i += 1) {

            int nsum = 0;
            for (int j = i; j < i + pChars.length && j < sChars.length; j++) {
                nsum += sChars[j];
                if (!pSet.contains(sChars[j]) || nsum > psum) {
                    i = j;
                    break;
                } else if (nsum == psum) {
                    anagrams.add(i);
                }
            }
        }


        return anagrams;
    }


}
