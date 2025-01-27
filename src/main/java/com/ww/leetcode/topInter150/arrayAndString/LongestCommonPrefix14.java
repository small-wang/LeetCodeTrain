package com.ww.leetcode.topInter150.arrayAndString;

/**
 * @since 2024/12/20 17:24
 */
public class LongestCommonPrefix14 {

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        char tmp;
        int i = 0;
        boolean stop = false;

        while(!stop) {

            if (i >= strs[0].length()) {
                stop = true;
            } else {
                tmp = strs[0].charAt(i);
                for (int j = 1; j <= strs.length - 1; j++) {
                    if (i >= strs[j].length()) {
                        stop = true;
                        break;
                    } else {
                        char strsChar = strs[j].charAt(i);
                        if (tmp != strsChar) {
                            stop = true;
                            break;
                        }
                    }
                }

                if (!stop) {
                    result += tmp;
                }
            }

            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix14 longestCommonPrefix14 = new LongestCommonPrefix14();
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix14.longestCommonPrefix(strs));
    }
}
