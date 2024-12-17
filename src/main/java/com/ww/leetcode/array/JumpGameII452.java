package com.ww.leetcode.array;

/**
 * @since 2024/12/13 13:07
 */
public class JumpGameII452 {

    public int jump(int[] nums) {
        int indexBegin = 0;
        int indexEnd = 0;
        int length = nums.length - 1;
        int result = 0;

        while (true) {
            if (indexEnd >= length) {
                break;
            } else if (indexBegin > indexEnd) {
                result = 0;
                break;
            } else {
                result += 1;
                int indexMax = calculate(nums, indexBegin, indexEnd);
                indexBegin = indexEnd + 1;
                indexEnd = indexMax;
            }
        }

        return result;
    }

    private int calculate(int[] nums, int indexBegin, int indexEnd) {
        int indexMax = 0;
        while (indexBegin <= indexEnd) {
            indexMax = Math.max(indexMax, nums[indexBegin] + indexBegin);
            indexBegin++;
        }

        return indexMax;
    }

    public static void main(String[] args) {
        JumpGameII452 jumpGameII452 = new JumpGameII452();
        int[] nums = {1, 3, 0, 0, 5};
        System.out.println(jumpGameII452.jump(nums));
    }

}
