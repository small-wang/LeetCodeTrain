package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Traverse;
import com.ww.leetcode.tree.base.TreeNode;

/**
 * @since 2022/6/11 15:12
 */
public class FlattenBinaryTreetoLinkedList114 {

    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (null != left) {
            root.left = null;
            root.right = left;
            while (null != left.right) {
                left = left.right;
            }
            left.right = right;
        }
    }


    public static void main(String[] ags) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        System.out.println("levelTraverse:");
        Traverse.levelTraverse(treeNode1);
        FlattenBinaryTreetoLinkedList114 flattenBinaryTreetoLinkedList114 = new FlattenBinaryTreetoLinkedList114();
        flattenBinaryTreetoLinkedList114.flatten(treeNode1);
        System.out.println("levelTraverse:");
        Traverse.levelTraverse(treeNode1);
    }
}
