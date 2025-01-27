package com.ww.leetcode.topInter150.arrayAndString;

/**
 * @since 2023/11/3 8:51
 */
public class RotateArray189 {

    public void rotate(int[] nums, int k) {
        if(nums.length < 2) {
            return;
        }
        else{
            if (k >= nums.length) {
                k = k % nums.length;
            }
            if (k == 0) {
                return;
            } else {
                int[] tmp = new int[k];
                System.arraycopy(nums, nums.length - k, tmp, 0, k);
                System.arraycopy(nums, 0, nums, k, nums.length - k);
                System.arraycopy(tmp, 0, nums, 0, k);
            }
        }
    }

    public static void main(String[] args) {
        RotateArray189 rotateArray189 = new RotateArray189();
        int[] nums = {0, 1, 2, 3, 4};
        int k = 6;

        rotateArray189.rotate(nums, k);
        for(int i : nums) {
            System.out.println(i);
        }
    }
}
