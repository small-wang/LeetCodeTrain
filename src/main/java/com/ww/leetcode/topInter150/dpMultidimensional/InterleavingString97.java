package com.ww.leetcode.topInter150.dpMultidimensional;

/**
 * @since 2025/3/5 13:43
 */
public class InterleavingString97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if (s1.length() == 0) {
            return s2.equals(s3);
        }

        if (s2.length() == 0) {
            return s1.equals(s3);
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i <= s1.length() - 1; i++) {
            if (s1.charAt(i) == s3.charAt(i)) {
                dp[i+1][0] = true;
            } else {
                break;
            }
        }

        for (int i = 0; i <= s2.length() - 1; i++) {
            if (s2.charAt(i) == s3.charAt(i)) {
                dp[0][i+1] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if ((dp[i-1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString97().isInterleave("ab", "cd", "abcd"));
    }
}
