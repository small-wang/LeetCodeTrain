package com.ww.leetcode.topInter150.arrayAndString;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 2024/12/20 14:31
 */
public class RomantoInteger13 {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);

        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);

        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int sum = 0;
        int index = 0;
        int length = s.length();
        while (true) {
            if (index >= length) {
                break;
            }

            if (index == length - 1) {
                sum += map.get(s.substring(index, index + 1));
                index += 1;
            } else {
                String twoStr = s.substring(index, index + 2);
                if (null != map.get(twoStr)) {
                    sum += map.get(twoStr);
                    index += 2;
                } else {
                    String oneStr = s.substring(index, index + 1);
                    sum += map.get(oneStr);
                    index += 1;
                }
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        RomantoInteger13 romantoInteger13 = new RomantoInteger13();
        int result = romantoInteger13.romanToInt("LVIII");
        System.out.println(result);
    }
}
