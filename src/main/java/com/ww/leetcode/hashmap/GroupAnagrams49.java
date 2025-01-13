package com.ww.leetcode.hashmap;

import java.util.*;

/**
 * @since 2025/1/2 10:12
 */
public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String newStr = String.valueOf(strChars);
            result.putIfAbsent(newStr, new LinkedList<>());
            result.get(newStr).add(str);
        }

        return new LinkedList<>(result.values());
    }

    public static void main(String[] args) {
        new GroupAnagrams49().groupAnagrams(new String[]{""}).stream().forEach(x -> x.stream().forEach(y -> System.out.println(y)));
    }
}
