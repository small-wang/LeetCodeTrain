package com.ww.leetcode.arrayAndString;

/**
 * @since 2023/11/2 9:28
 */
public class RemoveDuplicatesfromSortedArrayII80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        } else {
            int m = 2, n = 2;
            while (n < nums.length) {
                if (nums[n] <= nums[m-2]) {
                    n++;
                } else {
                    nums[m] = nums[n];
                    m++;
                    n++;
                }
            }
            return m;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII80 removeDuplicatesfromSortedArrayII80 = new RemoveDuplicatesfromSortedArrayII80();
        int[] nums = {0,0,1,1,1,1,2,2,2,2,3,3};

        int result = removeDuplicatesfromSortedArrayII80.removeDuplicates(nums);
        System.out.println(result);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
