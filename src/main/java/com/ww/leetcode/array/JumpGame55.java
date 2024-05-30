package com.ww.leetcode.array;

/**
 * @since 2023/11/23 9:56
 */
public class JumpGame55 {


    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            } else {
                max = Integer.max(max, i + nums[i]);
            }
        }
        return true;
    }


//    private boolean result = false;
//    public boolean canJump(int[] nums) {
//        canJump(nums, 0);
//        return result;
//    }
//
//    private void canJump(int[] nums, int i) {
//        if (i + nums[i] >= nums.length - 1) {
//            result = true;
//            return;
//        }
//        else {
//           for (int j = 1; j <= nums[i]; j++) {
//               canJump(nums, i + j);
//           }
//        }
//    }

    public static void main(String[] args) {
        JumpGame55 jumpGame55 = new JumpGame55();
        int[] nums = {3,2,1,0,4};

        boolean result = jumpGame55.canJump(nums);
        System.out.println(result);
    }
}
