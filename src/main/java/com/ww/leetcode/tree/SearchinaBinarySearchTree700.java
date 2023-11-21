package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Traverse;
import com.ww.leetcode.tree.base.TreeNode;

/**
 * @since 2022/6/20 15:33
 */
public class SearchinaBinarySearchTree700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return root;
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
        SearchinaBinarySearchTree700 searchinaBinarySearchTree700 = new SearchinaBinarySearchTree700();
        TreeNode treeNode = searchinaBinarySearchTree700.searchBST(treeNode1, 1);
        System.out.println(treeNode);
    }
}
