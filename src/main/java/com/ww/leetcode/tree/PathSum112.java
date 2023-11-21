package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Traverse;
import com.ww.leetcode.tree.base.TreeNode;

/**
 * @since 2022/7/7 9:49
 */
public class PathSum112 {

    private boolean result = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(null == root) {
            return result;
        }
        hasPathSum(root, targetSum, 0);
        return result;
    }

    private void hasPathSum(TreeNode root, int targetSum, int i) {
        if(null == root) {
            return;
        }
        if(null == root.left && null == root.right) {
            if(root.val + i == targetSum) {
                result = true;
            }
            return;
        }
        hasPathSum(root.left, targetSum, root.val + i);
        hasPathSum(root.right, targetSum, root.val + i);
    }

    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(6, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(4, treeNode2, treeNode3);

        System.out.println("Traverse.inorderTraverse");
        Traverse.inorderTraverse(treeNode1);
        PathSum112 pathSum112 = new PathSum112();
        boolean result = pathSum112.hasPathSum(treeNode1, 7);
        System.out.println(result);
    }
}
