package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Traverse;
import com.ww.leetcode.tree.base.TreeNode;

/**
 * @since 2022/6/20 13:45
 */
public class ConvertBSTtoGreaterTree538 {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        inorderTraverse(root);
        return root;
    }

    private void inorderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }
        inorderTraverse(root.right);
        sum += root.val;
        root.val = sum;
        inorderTraverse(root.left);
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
        ConvertBSTtoGreaterTree538 convertBSTtoGreaterTree538 = new ConvertBSTtoGreaterTree538();
        convertBSTtoGreaterTree538.convertBST(treeNode1);
        System.out.println("Traverse.inorderTraverse");
        Traverse.inorderTraverse(treeNode1);
    }
}
