package com.ww.leetcode.tree.base;

/**
 * @since 2022/6/11 13:45
 */
public class Main {

    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        System.out.println("preorderTraverse:");
        Traverse.preorderTraverse(treeNode1);

        System.out.println("inorderTraverse:");
        Traverse.inorderTraverse(treeNode1);

        System.out.println("postorderTraverse:");
        Traverse.postorderTraverse(treeNode1);

        System.out.println("levelTraverse:");
        Traverse.levelTraverse(treeNode1);
    }
}
