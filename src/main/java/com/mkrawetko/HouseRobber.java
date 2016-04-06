package com.mkrawetko;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p/>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int robbedPrevious = 0;
        int donNotRobbedPrevious = 0;
        for (int num : nums) {

            final int currentNotRobbed = Math.max(robbedPrevious, donNotRobbedPrevious);
            final int currentIsRobbed = donNotRobbedPrevious + num;

            robbedPrevious = currentIsRobbed;
            donNotRobbedPrevious = currentNotRobbed;

        }


        return Math.max(robbedPrevious, donNotRobbedPrevious);
    }


}
