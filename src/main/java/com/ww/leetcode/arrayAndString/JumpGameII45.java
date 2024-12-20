package com.ww.leetcode.arrayAndString;

/**
 * @since 2023/11/24 10:42
 */
public class JumpGameII45 {

    private int result = 0;
    public int jump(int[] nums) {
        result = nums.length;
        // TODO
        if(0 + nums[0] >= nums.length - 1) {
            return 1;
        } else {
            jump(nums, 0, 1);
        }

        return result;
    }

    private void jump(int[] nums, int i, int tmp) {
        if(tmp >= result) {
            return;
        }
        for (int j = i+1; j < nums[i]; j++) {
            if (j + nums[j] >= nums.length - 1 && tmp < result) {
                result = tmp + 1;
                break;
            } else {
                tmp++;
                jump(nums, j, tmp);
            }
        }
    }

    public static void main(String[] args) {
        JumpGameII45 jumpGameII45 = new JumpGameII45();
        int[] nums = {1,2,3,4,5};

        int result = jumpGameII45.jump(nums);
        System.out.println(result);
    }
}
