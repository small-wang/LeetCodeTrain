package com.ww.leetcode.topInter150.dp1d;

/**
 * @since 2025/2/24 14:41
 */
public class LongestIncreasingSubsequence300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i <= dp.length - 1; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i <= nums.length - 1; i++) {
            for (int j = 1; j <= i ; j++) {
                if (nums[i] > nums[i - j]) {
                    dp[i] = Math.max(dp[i], dp[i-j] + 1);
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence300().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
