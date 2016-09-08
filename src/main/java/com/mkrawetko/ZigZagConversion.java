package com.mkrawetko;

/*

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class ZigZagConversion {

    public String convert(String s, int numRows) {

        if (numRows <= 1 || numRows >= s.length()) {
            return s;
        }
        int idx = 0;
        StringBuilder[] accu = new StringBuilder[numRows];
        while (idx < s.length()) {
            for (int i = 0; i < numRows && idx < s.length(); i++) {
                StringBuilder row = accu[i];
                if (row == null) {
                    row = new StringBuilder();
                    accu[i] = row;
                }
                row.append(s.charAt(idx++));
            }
            for (int i = numRows - 2; i > 0; i--) {
                if (idx >= s.length()) {
                    break;
                }
                accu[i].append(s.charAt(idx++));
            }
        }

        String r = "";
        for (StringBuilder anAccu : accu) {
            r += anAccu.toString();
        }

        return r;
    }
}
