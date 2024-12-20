package com.ww.leetcode.arrayAndString;

/**
 * @since 2024/12/20 17:19
 */
public class LengthofLastWord58 {

    public int lengthOfLastWord(String s) {

        int sum = 0;
        s = s.trim();
        for(int i = s.length() - 1; i >= 0; i--) {
            if (" ".equals(s.substring(i, i+1))) {
                break;
            } else {
                sum++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        LengthofLastWord58 lengthofLastWord58 = new LengthofLastWord58();
        System.out.println(lengthofLastWord58.lengthOfLastWord("Hello World"));
    }
}
