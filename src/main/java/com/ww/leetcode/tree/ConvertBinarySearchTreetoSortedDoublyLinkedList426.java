package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.TreeNode;

import static com.ww.leetcode.tree.base.Traverse.postorderTraverse;

/**
 * @since 2022/6/20 19:45
 */
//TODO
public class ConvertBinarySearchTreetoSortedDoublyLinkedList426 {

    public TreeNode convertBST(TreeNode root) {
        return postorderTraverse(root);
    }

    private TreeNode postorderTraverse(TreeNode root) {
        if(null == root){
            return null;
        }
        return root;
    }
}
