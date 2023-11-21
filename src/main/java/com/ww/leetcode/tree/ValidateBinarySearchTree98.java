package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Traverse;
import com.ww.leetcode.tree.base.TreeNode;

/**
 * @since 2022/6/20 14:56
 */
public class ValidateBinarySearchTree98 {

    private long max = Long.MIN_VALUE;
    private boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        if(null == root.left && null == root.right) {
            return true;
        }
        inorderTraverse(root);
        return isValid;
    }

    private void inorderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }
        inorderTraverse(root.left);
        if (root.val > max) {
            max = root.val;
        } else {
            isValid = false;
            return;
        }
        inorderTraverse(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(20);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(2147483647);
        TreeNode treeNode2 = new TreeNode(-1);
        TreeNode treeNode1 = new TreeNode(-2147483648, null, treeNode3);

        System.out.println("Traverse.inorderTraverse");
        Traverse.inorderTraverse(treeNode1);
        ValidateBinarySearchTree98 validateBinarySearchTree98 = new ValidateBinarySearchTree98();
        boolean result = validateBinarySearchTree98.isValidBST(treeNode1);
        System.out.println(result);
    }
}
