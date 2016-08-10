package com.mkrawetko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> accumulator = new ArrayList<>();
        findTwoSum(nums, 0, 0, target, accumulator);


        return Arrays.stream(accumulator.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
    }

    public void findTwoSum(int[] nums, int currentIdx, int currentSum, int target, List<Integer> accumulator) {
        if (currentIdx >= nums.length) {
            return;
        }
        int newSum = nums[currentIdx] + currentSum;

        if (newSum > target) {
            findTwoSum(nums, currentIdx + 1, currentSum, target, accumulator);
        } else if (newSum == target) {
            accumulator.add(currentIdx);
            return;
        }

        accumulator.add(currentIdx);
        findTwoSum(nums, currentIdx + 1, newSum, target, accumulator);

    }


}
