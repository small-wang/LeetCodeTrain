package com.ww.leetcode.topInter150.dpMultidimensional;

/**
 * @since 2025/2/25 10:06
 */
public class MinimumPathSum64 {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i <= grid.length - 1; i++) {
            for (int j = 0; j <= grid[0].length - 1; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i - 1 < 0 && j - 1 >= 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (i - 1 >= 0 && j - 1 < 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }

        return dp[dp.length - 1][dp[dp.length - 1].length - 1];
    }

    public static void main(String[] args) {
        int[][] grip = new int[][]{{1,3,10}, {1,5,1}, {4,2,1}};
        System.out.println(new MinimumPathSum64().minPathSum(grip));
//        System.out.println(grip.length);
//        System.out.println(grip[0].length);
//        System.out.println(grip[grip.length - 1][grip[grip.length - 1].length - 1]);
    }
}
