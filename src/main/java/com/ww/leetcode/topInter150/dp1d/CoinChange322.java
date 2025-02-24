package com.ww.leetcode.topInter150.dp1d;

/**
 * @since 2025/2/24 13:53
 */
public class CoinChange322 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j <= coins.length - 1; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] > 0) {
                    dp[i] = (dp[i] > 0) ? Math.min(dp[i], dp[i - coins[j]] + 1) : dp[i - coins[j]] + 1;
                }
            }
        }

        return dp[amount] > 0 ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange322().coinChange(new int[]{1,2,5}, 4));
    }
}
