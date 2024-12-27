package com.ww.leetcode.slidingWindow;

import java.util.LinkedList;
import java.util.List;

/**
 * @since 2024/12/27 13:44
 */
public class SubstringwithConcatenationofAllWords30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();

        if (0 == s.length() || null == words ||0 == words.length) {
            return result;
        }

        if (s.length() < words[0].length() * words.length) {
            return result;
        }

        while (true) {

            break;
        }

        return result;
    }

    public static void main(String[] args) {
        new SubstringwithConcatenationofAllWords30().findSubstring("aa", new String[]{"a"}).stream().forEach(x -> System.out.println(x));
    }
}
