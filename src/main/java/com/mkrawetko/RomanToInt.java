package com.mkrawetko;


/**
 * Easy
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInt {

    public int romanToInt(String romanStr) {
        int result = 0;
        for (int i = 0; i < romanStr.length(); i++) {
            RomanNumber curr = new RomanNumber(romanStr.charAt(i));
            RomanNumber next = i < romanStr.length() - 1 ? new RomanNumber(romanStr.charAt(i + 1)) : null;
            if (next != null && curr.intValue < next.intValue) {
                result += next.intValue - curr.intValue;
                i++;
            } else {
                result += curr.intValue;
            }
        }
        return result;
    }

    public int romanToInt_Backwards(String romanStr) {
        int result = 0;
        RomanNumber prev = new RomanNumber(romanStr.charAt(romanStr.length() - 1));
        result += prev.intValue;
        for (int i = romanStr.length() - 2; i >= 0; i--) {
            RomanNumber curr = new RomanNumber(romanStr.charAt(i));
            if (curr.intValue < prev.intValue) {
                result -= curr.intValue;
            } else {
                result += curr.intValue;
            }
            prev = curr;
        }
        return result;
    }

    public int romanToInt_Recursive(String romanStr) {
        return new RomanNumber(romanStr.charAt(romanStr.length() - 1)).intValue + romanToIntRecursiveInternal(romanStr.length() - 2, romanStr);
    }

    private int romanToIntRecursiveInternal(int i, String romanStr) {
        if (i < 0) {
            return 0;
        } else {
            RomanNumber curr = new RomanNumber(romanStr.charAt(i));
            int currVal = curr.intValue;
            if (new RomanNumber(romanStr.charAt(i + 1)).intValue > curr.intValue) {
                currVal *= -1;
            }
            return currVal + romanToIntRecursiveInternal(--i, romanStr);
        }
    }

    static class RomanNumber {
        public final char roman;
        public final int intValue;

        public RomanNumber(char roman) {
            this.roman = roman;
            switch (roman) {
                case 'I':
                    this.intValue = 1;
                    break;
                case 'V':
                    this.intValue = 5;
                    break;
                case 'X':
                    this.intValue = 10;
                    break;
                case 'L':
                    this.intValue = 50;
                    break;
                case 'C':
                    this.intValue = 100;
                    break;
                case 'D':
                    this.intValue = 500;
                    break;
                case 'M':
                    this.intValue = 1000;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Roman Sign: " + roman);
            }
        }
    }

}
