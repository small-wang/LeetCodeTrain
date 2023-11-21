package com.ww.leetcode.array;

import java.util.Arrays;

/**
 * @since 2023/11/2 9:03
 */
public class RemoveElement27 {

    public int removeElement(int[] nums, int val) {
        int notEqual = 0;
        for (int m = 0, n = nums.length - 1; m <= n; ) {
            if(nums[m] != val) {
                notEqual++;
                m++;
            }
            else {
                int tmp = nums[m];
                nums[m] = nums[n];
                nums[n] = tmp;
                n--;
            }
        }

        return notEqual;
    }

    public static void main(String[] args) {
        RemoveElement27 removeElement27 = new RemoveElement27();
        int[] nums = {1, 2, 3, 1};
        int val = 1;

        int result = removeElement27.removeElement(nums, val);
        System.out.println(result);
        for(int i : nums) {
            System.out.println(i);
        }
    }
}
