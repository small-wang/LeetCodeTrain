package com.ww.leetcode.twopointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @since 2024/12/25 13:41
 */
public class Sum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (null == nums || 0 == nums.length) {

        } else {
            Arrays.sort(nums);
            for (int i = 0; i <= nums.length - 1; i++) {
                if (i > 0 && nums[i] == nums[i-1]) {
                    continue;
                } else {
                    sum2(nums, 0 - nums[i], i+1, result);
                }
            }
        }

        return result;
    }

    private void sum2(int[] nums, int target, int i, List<List<Integer>> result) {
        if (i >= nums.length - 1) {
            return;
        } else {
            int beginIndex = i;
            int endIndex = nums.length - 1;

            while (true) {
                if (beginIndex >= endIndex) {
                    break;
                } else {
                    if (beginIndex > i && nums[beginIndex] == nums[beginIndex - 1]) {
                        beginIndex++;
                    } else if (endIndex < nums.length - 1 && nums[endIndex] == nums[endIndex + 1]) {
                        endIndex--;
                    } else {
                        if (nums[beginIndex] + nums[endIndex] == target) {
                            List<Integer> list = new LinkedList<>();
                            list.add(0 - target);
                            list.add(nums[beginIndex]);
                            list.add(nums[endIndex]);
                            result.add(list);
                            beginIndex++;
                            endIndex--;
                        } else if (nums[beginIndex] + nums[endIndex] < target) {
                            beginIndex++;
                        } else {
                            endIndex--;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Sum15().threeSum(new int[]{-1,0,1,2,-1,-4}).stream().forEach(x -> x.stream().forEach(y -> System.out.println(y)));
    }
}
