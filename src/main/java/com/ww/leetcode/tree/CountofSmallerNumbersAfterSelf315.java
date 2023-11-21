package com.ww.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2022/6/14 20:18
 */
//TODO
public class CountofSmallerNumbersAfterSelf315 {

    private List<Integer> list = new ArrayList<>();
    private int[] tmp;

    public List<Integer> countSmaller(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }
        tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list.add(i, 0);
        }
        sort(nums, 0, nums.length - 1);
        return list;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            tmp[i] = nums[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                nums[p] = tmp[j];
                j++;
            } else if (j == hi + 1) {
                nums[p] = tmp[i];
                i++;
            } else if (tmp[i] > tmp[j]) {
                nums[p] = tmp[j];
                j++;
//                list.set(p, list.get(p) + (j - mid - 1));
            } else {
                nums[p] = tmp[i];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        CountofSmallerNumbersAfterSelf315 countofSmallerNumbersAfterSelf315 = new CountofSmallerNumbersAfterSelf315();
        int[] nums = new int[]{5, 2, 6, 1};
        List<Integer> list = countofSmallerNumbersAfterSelf315.countSmaller(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

}
