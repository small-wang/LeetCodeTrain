package com.ww.leetcode.twopointers;

/**
 * @since 2024/12/24 14:31
 */
public class IsSubsequence392 {

    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;

        while (true) {
            if (sIndex >= s.length() || tIndex >= t.length()) {
                break;
            }

            char sChar = s.charAt(sIndex);
            char tChar = t.charAt(tIndex);
            if (sChar == tChar) {
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }

        if (sIndex == s.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence392().isSubsequence("axc", "ahbgdc"));
    }
}
