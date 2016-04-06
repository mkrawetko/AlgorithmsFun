package com.mkrawetko;


/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInt {

    static short h[] = new short[22];

    static {
        h[6] = 1;
        h[19] = 5;
        h[21] = 10;
        h[9] = 50;
        h[0] = 100;
        h[1] = 500;
        h[10] = 1000;
    }

    public int romanToInt(String romanStr) {

        int sum = 0;
        int currentIdx = 0;
        for (int i = 0; i < romanStr.length(); i++) {
            short cur = h[romanStr.charAt(i) - 67];
            short next = (i + 1) < romanStr.length() ? h[romanStr.charAt(i + 1) - 67] : -1;
            if (cur < next) {
                sum += next - cur;
                i++;
            } else {
                sum += cur;
            }
        }

        return sum;
    }

}
