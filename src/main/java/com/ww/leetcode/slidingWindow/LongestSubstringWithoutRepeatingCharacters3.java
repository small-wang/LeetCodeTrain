package com.ww.leetcode.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @since 2024/12/27 9:35
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (true) {
            if (right >= s.length()) {
                break;
            } else {
                if (!set.contains(s.charAt(right))) {
                    set.add(s.charAt(right));
                    result = Math.max(result, right - left + 1);
                    right++;
                } else {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
        }

        return result == 0 ? s.length() : result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters3().lengthOfLongestSubstring("ab"));
    }
}
