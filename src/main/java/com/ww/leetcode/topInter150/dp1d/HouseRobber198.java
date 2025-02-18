package com.ww.leetcode.topInter150.dp1d;

/**
 * @since 2025/2/18 10:33
 */
public class HouseRobber198 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = nums[0];

        for (int i = 3; i <= nums.length + 1; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i - 2];
        }

        return Math.max(dp[nums.length + 1], dp[nums.length]);
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber198().rob(new int[]{2,7,9,3,1}));
    }
}
