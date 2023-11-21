package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Traverse;
import com.ww.leetcode.tree.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @since 2022/6/11 14:09
 */
public class InvertBinaryTree226 {

    public static TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }

        return root;
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
        TreeNode inverTreeNode = invertTree(treeNode1);
        System.out.println("levelTraverse:");
        Traverse.levelTraverse(inverTreeNode);
    }
}
