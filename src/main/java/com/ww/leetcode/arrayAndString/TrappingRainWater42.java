package com.ww.leetcode.arrayAndString;

/**
 * @since 2024/12/19 9:53
 * 初始化两个数组，分别记录每个元素的左侧的最大高度，右侧最大高度
 * 正序遍历，记录每个元素的左侧的最大高度：如果i-1的高度大于元素i的高度，则记录元素i的左侧最大高度为height[i-1]；如果i-1的高度小于等于元素i的高度，则记录元素i的左侧最大高度为height[i]本身；
 * 倒序遍历，记录每个元素的右侧的最大高度：如果i+1的高度大于元素i的高度，则记录元素i的右侧最大高度为height[i+1]；如果i+1的高度小于等于元素i的高度，则记录元素i的右侧最大高度为height[i]本身；
 * 每个元素接雨滴数，等于min(左侧最大高度，右侧最大高度)-元素本身高度；
 * 结果等于每个元素接雨滴数的总和；
 */
public class TrappingRainWater42 {

    public int trap(int[] height) {
        if (null == height || 0 == height.length) {
            return 0;
        } else {
            int sum = 0;
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];
            leftMax[0] = height[0];
            rightMax[height.length-1] = height[height.length-1];

            for (int i = 1; i <= height.length - 1; i++) {
                if (height[i] < leftMax[i-1]) {
                    leftMax[i] = leftMax[i-1];
                } else {
                    leftMax[i] = height[i];
                }
            }

            for (int i = height.length-2; i >= 0; i--) {
                if (height[i] < rightMax[i+1]) {
                    rightMax[i] = rightMax[i+1];
                } else {
                    rightMax[i] = height[i];
                }
            }

            for (int i = 0; i < height.length; i++) {
                sum += Math.min(leftMax[i], rightMax[i]) - height[i];
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        TrappingRainWater42 trappingRainWater42 = new TrappingRainWater42();
        int[] height = {1,2,1,2,3};
        int result = trappingRainWater42.trap(height);
        System.out.println(result);
    }
}
