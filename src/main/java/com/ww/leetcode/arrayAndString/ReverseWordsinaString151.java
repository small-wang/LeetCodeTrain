package com.ww.leetcode.arrayAndString;

import java.util.LinkedList;
import java.util.List;

/**
 * @since 2024/12/23 13:26
 */
public class ReverseWordsinaString151 {

    public String reverseWords(String s) {
        String result = "";

        int second = 0;
        int before = 0;
        List<String> list = new LinkedList<>();
        while (before < s.length()) {
            if (' ' == s.charAt(before)) {
                String str = s.substring(second, before);
                if (!"".equals(str)) {
                    list.add(str);
                }
                before++;
                second = before;
            } else {
                before++;
            }
        }
        if (second < before) {
            list.add(s.substring(second, before));;
        }

        String tmp = "";
        for (int i = 0; i < (list.size() / 2); i++) {
            tmp = list.get(i);
            list.set(i, list.get(list.size() - 1 - i));
            list.set(list.size() - 1 - i, tmp);
        }

        for (int i = 0; i <= (list.size() - 1); i++) {
            result += list.get(i) + " ";
        }

        return result.trim();
    }

    public static void main(String[] args) {
        ReverseWordsinaString151 reverseWordsinaString151 = new ReverseWordsinaString151();
        String s = "a good   e";
        System.out.println(reverseWordsinaString151.reverseWords(s));
    }
}
