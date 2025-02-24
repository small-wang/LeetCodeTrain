package com.ww.leetcode.topInter150.dp1d;

import java.util.Arrays;
import java.util.List;

/**
 * @since 2025/2/18 10:53
 */
public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        int maxWordLength = 0;
        for (String word : wordDict) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= maxWordLength && j <= i; j++) {
                if (dp[i - j] && wordDict.contains(s.substring(i - j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
//        System.out.println("asd".substring(2, 3));
        String[] in = new String[]{"cats","dog","sand","and","cat"};
        System.out.println(new WordBreak139().wordBreak("catsandog", Arrays.asList(in)));
    }
}
