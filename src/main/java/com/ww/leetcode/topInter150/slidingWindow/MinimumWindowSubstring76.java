package com.ww.leetcode.topInter150.slidingWindow;

/**
 * @since 2024/12/30 16:03
 */
public class MinimumWindowSubstring76 {

    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int count = t.length();
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();

        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" :
                new String(chS, startIndex, minLen);
    }

//    public String minWindow(String s, String t) {
//
//        String result = s + t;
//        int left = 0;
//        int right = 0;
//        Map<Character, Integer> tmpMap = new HashMap<>();
//        Map<Character, Integer> destMap = new HashMap<>();
//        for (char c : t.toCharArray()) {
//            destMap.put(c, destMap.getOrDefault(c, 0) + 1);
//        }
//
//        while (true) {
//            if (right >= s.length()) {
//                break;
//            } else {
//                char rightChar = s.charAt(right);
//                int destCharCount = destMap.getOrDefault(rightChar, 0);
//                right++;
//
//                if (0 != destCharCount) {
//                    tmpMap.put(rightChar, tmpMap.getOrDefault(rightChar, 0) + 1);
//                    if (isSame(tmpMap, destMap)) {
//                        while (true) {
//                            if (!isSame(tmpMap, destMap)) {
//                                break;
//                            }
//                            if (result.length() > right - left) {
//                                result = s.substring(left, right);
//                            }
//                            char leftChar = s.charAt(left);
//                            if (0 != destMap.getOrDefault(leftChar, 0)) {
//                                tmpMap.put(leftChar, tmpMap.get(leftChar) - 1);
//                            }
//                            left++;
//                        }
//                    }
//                }
//            }
//        }
//
//        return result.length() > s.length() ? "" : result;
//    }
//
//    private boolean isSame(Map<Character, Integer> tmpMap, Map<Character, Integer> destMap) {
//        Iterator<Character> iterator = destMap.keySet().iterator();
//        while (iterator.hasNext()) {
//            Character key = iterator.next();
//            if (destMap.getOrDefault(key, 0) > tmpMap.getOrDefault(key, 0)) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring76().minWindow("ADOBECODEBANC", "ABC"));
    }
}
