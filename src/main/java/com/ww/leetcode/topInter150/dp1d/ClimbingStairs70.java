package com.ww.leetcode.topInter150.dp1d;

/**
 * @since 2025/2/18 10:24
 */
public class ClimbingStairs70 {

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs70().climbStairs(4));
    }
}
