package com.ww.leetcode.tree;

/**
 * @since 2022/6/17 13:17
 */
public class SortanArray912 {

    private int[] tmp;

    public int[] sortArray(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }
        tmp = new int[nums.length];
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortArray(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sortArray(nums, lo, mid);
        sortArray(nums, mid + 1, hi);
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
            } else {
                nums[p] = tmp[i];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        SortanArray912 sortanArray912 = new SortanArray912();
        int[] nums = new int[]{5, 2, 6, 1, 0, 0};
        int[] sortNums = sortanArray912.sortArray(nums);
        for (int i : sortNums) {
            System.out.println(i);
        }
    }
}
