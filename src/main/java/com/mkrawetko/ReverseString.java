package com.mkrawetko;

import static java.lang.String.valueOf;

/**
 * https://leetcode.com/problems/reverse-string/
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * <p>
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
public class ReverseString {

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        return valueOf(chars);
    }

    public String reverseStringRecursive(String s) {
        char[] chars = s.toCharArray();
        reverseStringRecursive(0, chars);
        return valueOf(chars);
    }

    private void reverseStringRecursive(Integer curIdx, char[] chars) {
        if (curIdx < chars.length / 2) {
            char tmp = chars[curIdx];
            chars[curIdx] = chars[chars.length - 1 - curIdx];
            chars[chars.length - 1 - curIdx] = tmp;
            reverseStringRecursive(curIdx + 1, chars);
        }
    }


    public String reverseStringSubString(String s) {
        StringBuilder answer = new StringBuilder();
        while (s.length() > 0) {
            answer.append(s.charAt(s.length() - 1));
            s = s.substring(0, s.length() - 1);
        }
        return answer.toString();
    }


    public String reverseStringSubStringRecursive(String s) {
        if (s.length() == 0) {
            return s;
        }
        return reverseStringSubStringRecursive(s.substring(1)) + s.charAt(0);
    }


}