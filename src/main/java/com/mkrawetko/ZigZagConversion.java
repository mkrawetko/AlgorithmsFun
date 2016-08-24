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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZigZagConversion {

    public String convert(String s, int numRows) {

        String r = "";
        Map<Integer, List<Integer>> strPerRow = new HashMap<>();

        int idx = 0;
        while (idx < s.length()) {
            for (int i = 0; i < numRows && idx < s.length(); i++) {
                List<Integer> row = strPerRow.get(i);
                if (row == null) {
                    row = new ArrayList<>();
                    strPerRow.put(i, row);
                }
                row.add(idx++);
            }
            for (int i = numRows - 2; i > 0; i--) {
                if (idx >= s.length()) {
                    break;
                }
                strPerRow.get(i).add(idx++);
            }
        }

        for (int i = 0; i < strPerRow.keySet().size(); i++) {
            List<Integer> row = strPerRow.get(i);
            for (Integer charIdx : row) {
                r += s.substring(charIdx, charIdx + 1);
            }
        }

        return r;
    }
}
