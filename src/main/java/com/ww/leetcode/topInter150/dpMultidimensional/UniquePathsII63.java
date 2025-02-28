package com.ww.leetcode.topInter150.dpMultidimensional;

/**
 * @since 2025/2/25 10:25
 */
public class UniquePathsII63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i <= obstacleGrid.length - 1; i++) {
            for (int j = 0; j <= obstacleGrid[0].length - 1; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    } else if (i > 0) {
                        dp[i][j] = dp[i-1][j];
                    } else if (j > 0) {
                        dp[i][j] = dp[i][j-1];
                    } else {
                        dp[i][j] = 1;
                    }
                }
            }
        }

        return dp[dp.length - 1][dp[dp.length - 1].length - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(new UniquePathsII63().uniquePathsWithObstacles(obstacleGrid));
    }
}
