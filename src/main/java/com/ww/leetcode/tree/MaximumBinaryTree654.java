package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Traverse;
import com.ww.leetcode.tree.base.TreeNode;

/**
 * @since 2022/6/11 17:44
 */
public class MaximumBinaryTree654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }
        TreeNode treeNode = constructMaximumBinaryTree(nums, 0, nums.length - 1);
        return treeNode;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int index = maxElementIndex(nums, begin, end);
        TreeNode treeNode = new TreeNode();
        treeNode.val = nums[index];
        TreeNode left = constructMaximumBinaryTree(nums, begin, index - 1);
        TreeNode right = constructMaximumBinaryTree(nums, index + 1, end);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }

    private int maxElementIndex(int[] nums, int begin, int end) {
        int max = nums[begin];
        int maxIndex = begin;
        for (int i = begin; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] ags) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        MaximumBinaryTree654 maximumBinaryTree654 = new MaximumBinaryTree654();
        TreeNode treeNode = maximumBinaryTree654.constructMaximumBinaryTree(nums);
        System.out.println("levelTraverse:");
        Traverse.levelTraverse(treeNode);
    }
}
