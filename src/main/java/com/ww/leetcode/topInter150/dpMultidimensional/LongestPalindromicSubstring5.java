package com.ww.leetcode.topInter150.dpMultidimensional;

/**
 * @since 2025/2/25 13:42
 */
public class LongestPalindromicSubstring5 {

    public String longestPalindrome(String s) {
        int maxLength = 1;
        String result = s.substring(0, 1);
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i <= s.length() - 1; i++) {
            dp[i][i] = true;
        }

        for (int length = 2; length <= s.length(); length++) {
            for (int i = 0; i + length <= s.length(); i++) {
                if ((dp[i+1][i+length-2] || length == 2) && s.charAt(i) == s.charAt(i + length - 1)) {
                    dp[i][i + length - 1] = true;
                    maxLength = length;
                    result = s.substring(i, i + length);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring5().longestPalindrome("cbbd"));
    }
}
