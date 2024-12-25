package com.ww.leetcode.twopointers;

/**
 * @since 2024/12/25 9:12
 *
 * 本题与TrappingRainWater42的区别：找出任意两个坐标，找出最大接水量maxArea，接水量=(endIndex - beginIndex) * min(beginHeight, endHeight)
 */
public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        } else {
            int maxArea = 0;
            int beginIndex = 0;
            int endIndex = height.length - 1;

            while (true) {
                if (beginIndex >= endIndex) {
                    break;
                } else {
                    int beginHeight = height[beginIndex];
                    int endHeight = height[endIndex];

                    maxArea = Math.max(maxArea, Math.min(endHeight, beginHeight) * (endIndex - beginIndex));
                    if (beginHeight <= endHeight) {
                        beginIndex++;
                    } else {
                        endIndex--;
                    }
                }
            }

            return maxArea;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater11().maxArea(new int[]{1,1}));
    }
}
