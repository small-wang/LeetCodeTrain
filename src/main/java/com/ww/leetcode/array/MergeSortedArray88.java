package com.ww.leetcode.array;

/**
 * @since 2023/11/2 8:37
 */
public class MergeSortedArray88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m >0 && n > 0){
            if (nums1[m-1] >= nums2[n-1]) {
                nums1[m+n-1] = nums1[m-1];
                m = m - 1;
            } else {
                nums1[m+n-1] = nums2[n-1];
                n = n - 1;
            }
        }
        while (n > 0) {
            nums1[m+n-1] = nums2[n-1];
            n = n - 1;
        }
        // 忽略，剩余nums1元素已经排列
//        while (m > 0) {
//
//        }
    }

    public static void main(String[] args) {
        MergeSortedArray88 mergeSortedArray88 = new MergeSortedArray88();
        int[] nums1 = {2, 6, 0, 0, 0};
        int[] nums2 = {1, 4, 5};
        int m = 2;
        int n = 3;

        mergeSortedArray88.merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
