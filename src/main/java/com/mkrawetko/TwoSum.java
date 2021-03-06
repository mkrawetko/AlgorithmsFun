package com.mkrawetko;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers,
 * return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public int[] twoSumArraySorted(int[] nums, int target) {
        Integer first = null;
        Integer second = null;
        int[] numsSorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsSorted);
        for (int i = 0; i < numsSorted.length - 1; i++) {
            int diff = target - numsSorted[i];
            for (int j = i + 1; j < numsSorted.length; j++) {
                if (numsSorted[j] == diff) {
                    for (int k = 0; k < nums.length; k++) {

                        if (nums[k] == numsSorted[i] && first == null && (second == null || k != second)) {
                            first = k;
                        }
                        if (nums[k] == numsSorted[j] && second == null && (first == null || k != first)) {
                            second = k;
                        }
                        if (first != null && second != null) {
                            int max = Math.max(first, second);
                            int min = Math.min(first, second);
                            return new int[]{min, max};
                        }
                    }
                } else if (numsSorted[j] > diff) {
                    break;
                }
            }
        }
        return new int[0];
    }

    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }


}
