package com.mkrawetko;


import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static final String DEFAULT = "";

    public List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            String result = DEFAULT;
            if (i % 3 == 0) {
                result += "Fizz";
            }
            if (i % 5 == 0) {
                result += "Buzz";
            }
            if (DEFAULT.equals(result)) {
                result += i;
            }
            results.add(result);
        }
        return results;
    }

}
