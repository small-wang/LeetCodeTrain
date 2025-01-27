package com.ww.leetcode.topInter150.twopointers;

/**
 * @since 2024/12/24 13:19
 */
public class ValidPalindrome125 {

    public boolean isPalindrome(String s) {
        int beginIndex = 0;
        int endIndex = s.length() - 1;
        while (true) {
            char beginChar = Character.toLowerCase(s.charAt(beginIndex));
            char endChar = Character.toLowerCase(s.charAt(endIndex));

            while (beginIndex < endIndex) {
                if (!Character.isLetterOrDigit(beginChar)) {
                    beginIndex++;
                    beginChar = Character.toLowerCase(s.charAt(beginIndex));
                } else if (!Character.isLetterOrDigit(endChar)) {
                    endIndex--;
                    endChar = Character.toLowerCase(s.charAt(endIndex));
                } else {
                    break;
                }
            }

            if (beginChar != endChar) {
                return false;
            }

            beginIndex++;
            endIndex--;
            if (beginIndex >= endIndex) {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome125().isPalindrome("a."));
    }
}
