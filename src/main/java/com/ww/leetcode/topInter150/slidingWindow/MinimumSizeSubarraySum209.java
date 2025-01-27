package com.ww.leetcode.topInter150.slidingWindow;

/**
 * @since 2024/12/25 16:28
 *
 * 滑动窗口
 * result：记录窗口内元素之和大于target时，窗口的最小值；
 * left：窗口左侧的索引；
 * right：窗口右侧的索引；
 * sum：窗口内的元素之和；
 *
 * 若当前窗口内元素之和sum<target：right++, sum=+nums[right];
 * 若当前窗口内元素之和sum>=target：result=min(result, right - left + 1), sum-=nums[left], left--;
 */
public class MinimumSizeSubarraySum209 {

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = nums[left];
        if (sum >= target) {
            return 1;
        }

        while (true) {
            if (left > nums.length - 1) {
                break;
            } else if (right == nums.length - 1 && sum < target) {
                break;
            } else {
                if (sum >= target) {
                    result = Math.min(result, right - left + 1);
                    sum -= nums[left];
                    left++;
                } else {
                    right++;
                    sum += nums[right];
                }
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }


//    public int minSubArrayLen(int target, int[] nums) {
//        int result = nums.length + 1;
//        int[] sums = new int[nums.length + 1];
//
//        for (int i = 1; i <= nums.length; i++) {
//            sums[i] = sums[i-1] + nums[i-1];
//        }
//
//        for (int i = 0; i <= nums.length - 1; i++) {
//            for (int j = i + 1; j <= sums.length - 1; j++) {
//                if (sums[j] - sums[i] >= target) {
//                    result = Math.min(result, j - i);
//                    break;
//                }
//            }
//        }
//
//        return result <= nums.length ? result : 0;
//    }
//
//    public int minSubArrayLen(int target, int[] nums) {
//        int left = 0, right = 0, sumOfCurrentWindow = 0;
//        int res = Integer.MAX_VALUE;
//
//        for(right = 0; right < nums.length; right++) {
//            sumOfCurrentWindow += nums[right];
//
//            while (sumOfCurrentWindow >= target) {
//                res = Math.min(res, right - left + 1);
//                sumOfCurrentWindow -= nums[left++];
//            }
//        }
//
//        return res == Integer.MAX_VALUE ? 0 : res;
//    }

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum209().minSubArrayLen(7, new int[]{1,1,1,1,7}));
    }
}
