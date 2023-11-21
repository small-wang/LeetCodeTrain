package com.ww.leetcode.tree.base;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @since 2022/6/11 13:32
 */
public class Traverse {

    /**
     * DFS
     * 前序遍历
     */
    public static void preorderTraverse(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        System.out.println(treeNode);
        preorderTraverse(treeNode.left);
        preorderTraverse(treeNode.right);
    }

    /**
     * 中序遍历
     */
    public static void inorderTraverse(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        inorderTraverse(treeNode.left);
        System.out.println(treeNode);
        inorderTraverse(treeNode.right);
    }

    /**
     * 后序遍历
     */
    public static void postorderTraverse(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        postorderTraverse(treeNode.left);
        postorderTraverse(treeNode.right);
        System.out.println(treeNode);
    }

    /**
     * BFS
     * 层遍历
     */
    public static void levelTraverse(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node);
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * BFS
     * 层遍历
     */
    public static void levelTraverse(Node treeNode) {
        if (null == treeNode) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node);
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }
    }
}
