package com.ww.leetcode.twopointers;

import java.util.Arrays;

/**
 * @since 2024/12/24 14:45
 */
public class TwoSumIIInputArrayIsSorted167 {

    public int[] twoSum(int[] numbers, int target) {
        int beginIndex = 0;
        int endIndex = numbers.length - 1;

        while (true) {
            if (beginIndex >= endIndex) {
                break;
            }

            if (numbers[beginIndex] + numbers[endIndex] == target) {
                break;
            } else if (numbers[beginIndex] + numbers[endIndex] < target) {
                beginIndex++;
            }
            else {
                endIndex--;
            }
        }

        if (numbers[beginIndex] + numbers[endIndex] == target) {
            return new int[]{beginIndex + 1, endIndex + 1};
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Arrays.stream(new TwoSumIIInputArrayIsSorted167().twoSum(new int[]{2, 7, 11, 15}, 10)).forEach(x -> System.out.println(x));
    }
}
