package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Traverse;
import com.ww.leetcode.tree.base.TreeNode;

/**
 * @since 2022/6/21 19:14
 */
public class InsertintoaBinarySearchTree701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            TreeNode treeNode = new TreeNode(val);
            return treeNode;
        }
        if (root.val > val && null == root.left) {
            root.left = new TreeNode(val);
        } else if (root.val < val && null == root.right) {
            root.right = new TreeNode(val);
        } else if (root.val > val) {
            insertIntoBST(root.left, val);
        } else if (root.val < val) {
            insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(5);
//        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(6, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, null);
        TreeNode treeNode1 = new TreeNode(4, treeNode2, treeNode3);

        System.out.println("Traverse.inorderTraverse");
        Traverse.inorderTraverse(treeNode1);
        InsertintoaBinarySearchTree701 insertintoaBinarySearchTree701 = new InsertintoaBinarySearchTree701();
        insertintoaBinarySearchTree701.insertIntoBST(treeNode1, 3);
        System.out.println("Traverse.inorderTraverse");
        Traverse.inorderTraverse(treeNode1);
    }

}
