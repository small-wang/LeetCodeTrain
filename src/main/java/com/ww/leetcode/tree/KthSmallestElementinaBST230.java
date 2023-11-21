package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Traverse;
import com.ww.leetcode.tree.base.TreeNode;

/**
 * @since 2022/6/17 13:33
 */
public class KthSmallestElementinaBST230 {

    private int k = 0;
    private int index = 0;
    private int val = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (null == root) {
            return val;
        }
        this.k = k;
        traverse(root);
        return val;
    }

    private void traverse(TreeNode node) {
        if (null == node) {
            return;
        }
        traverse(node.left);
        this.index++;
        if (this.index == this.k) {
            val = node.val;
            return;
        }
        traverse(node.right);
    }

    public static void main(String[] ags) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(6, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(4, treeNode2, treeNode3);

        System.out.println("levelTraverse:");
        Traverse.inorderTraverse(treeNode1);
        KthSmallestElementinaBST230 kthSmallestElementinaBST230 = new KthSmallestElementinaBST230();
        int val = kthSmallestElementinaBST230.kthSmallest(treeNode1, 1);
        System.out.println("val:" + val);
    }
}
