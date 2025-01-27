package com.ww.leetcode.topInter150.arrayAndString;

/**
 * @since 2024/12/23 14:31
 */
public class FindtheIndexoftheFirstOccurrenceinaString28 {

    public int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length()) {
            return -1;
        } else {
            for (int i = 0; i <= haystack.length() - 1; i++) {
                if (haystack.length() - i < needle.length()) {
                    return -1;
                } else {
                    String tmp = haystack.substring(i, i + needle.length());
                    if (tmp.equals(needle)) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindtheIndexoftheFirstOccurrenceinaString28 findtheIndexoftheFirstOccurrenceinaString28 = new FindtheIndexoftheFirstOccurrenceinaString28();
        System.out.println(findtheIndexoftheFirstOccurrenceinaString28.strStr("aleetaa", "leetc"));
    }
}
