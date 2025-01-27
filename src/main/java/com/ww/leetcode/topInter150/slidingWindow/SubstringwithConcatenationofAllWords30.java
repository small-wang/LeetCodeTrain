package com.ww.leetcode.topInter150.slidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @since 2024/12/27 13:44
 */
public class SubstringwithConcatenationofAllWords30 {

    private int wordLength;
    private int wordCount;
    private String s;
    private Map<String, Integer> mapDest;

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();

        if (0 == s.length() || null == words ||0 == words.length) {
            return result;
        }

        if (s.length() < words[0].length() * words.length) {
            return result;
        }

        // 初始化数据
        init(s, words);

        // 因查找的单词长度固定，轮询次数从0到wordLength-1，大于wordLength后与之前的窗口出现重复计算
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> mapTmp = new HashMap<>();
            findSubstring(i, i, mapTmp, result);
        }

        return result;
    }

    private void init(String s, String[] words) {
        int wordLength = words[0].length();
        int wordCount = words.length;
        Map<String, Integer> mapDest = new HashMap<>();
        for(int i = 0; i < wordCount; i++) {
            mapDest.put(words[i], mapDest.get(words[i]) == null ? 1 : mapDest.get(words[i]) + 1);
        }

        this.s = s;
        this.mapDest = mapDest;
        this.wordLength = wordLength;
        this.wordCount = wordCount;
    }

    // 滑动窗口递归查找，窗口索引right/left移动，每次移动量为wordLength
    private void findSubstring(int left, int right, Map<String, Integer> mapTmp, List<Integer> result) {
        if (right - left == this.wordLength * this.wordCount) {
            // 窗口长度等于words字符串长度之和，记录结果
            // left索引继续移动，往后计算
            result.add(left);
            String leftWord = this.s.substring(left, left + this.wordLength);
            mapTmp.put(leftWord, mapTmp.get(leftWord) - 1);
            left = left + this.wordLength;
            findSubstring(left, right, mapTmp, result);
        } else if (left + this.wordLength > this.s.length() || right + this.wordLength > this.s.length()) {
            // 索引超过s长度，停止递归
            return;
        } else {
            String rightWord = this.s.substring(right, right + this.wordLength);
            int wordDestCount = this.mapDest.get(rightWord) == null ? 0 : this.mapDest.get(rightWord);
            int wordTmpCount = mapTmp.get(rightWord) == null ? 0 : mapTmp.get(rightWord);

            if (0 == wordDestCount) {
                // words不包含字符串，left/right重新开始计数，将mapTmp清空
                left = right + this.wordLength;
                right = left;
                mapTmp.clear();
                findSubstring(left, right, mapTmp, result);
            } else {
                if (wordTmpCount < wordDestCount) {
                    // words包含字符串，且字符串数量没有达到上限，mapTmp字符串数量+1，右索引前移
                    mapTmp.put(rightWord, wordTmpCount + 1);
                    right = right + this.wordLength;
                    findSubstring(left, right, mapTmp, result);
                } else {
                    // words包含字符串，且字符串数量已经达到上限，mapTmp左字符数量-1，左索引前移
                    String leftWord = this.s.substring(left, left + this.wordLength);
                    mapTmp.put(leftWord, mapTmp.get(leftWord) - 1);
                    left = left + this.wordLength;
                    findSubstring(left, right, mapTmp, result);
                }
            }
        }
    }

    public static void main(String[] args) {
        new SubstringwithConcatenationofAllWords30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}).stream().forEach(x -> System.out.println(x));
    }
}
