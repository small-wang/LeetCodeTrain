package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Traverse;
import com.ww.leetcode.tree.base.TreeNode;

/**
 * @since 2022/6/28 17:40
 */
public class DeleteNodeinaBST450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        } else {
            if (root.val == key) {
                if (null == root.left && null == root.right) {
                    root = null;
                } else if (null == root.left) {
                    root = root.right;
                } else if (null == root.right) {
                    root = root.left;
                } else {
                    TreeNode min = getMin(root.right);
                    root.val = min.val;
                    root.right = deleteNode(root.right, min.val);
                }
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }

            return root;
        }
    }

    private TreeNode getMin(TreeNode root) {
        while (null != root.left) {
            root = root.left;
        }
        return root;
    }

//    public TreeNode deleteNode(TreeNode root, int key) {
//        if (null == root) {
//            return null;
//        } else if (root.val == key) {
//            return delete(root);
//        } else {
//            deleteTraverse(root, key);
//            return root;
//        }
//    }
//
//    public void deleteTraverse(TreeNode root, int key) {
//        if (root.val == key) {
//            delete(root);
//        } else if (root.val > key) {
//            deleteTraverse(root.left, key);
//        } else {
//            deleteTraverse(root.right, key);
//        }
//    }
//
//    private TreeNode delete(TreeNode root) {
//        if (null == root.left && null == root.right) {
//            return null;
//        } else if (null == root.right) {
//            return root.left;
//        } else if (null == root.left) {
//            return root.right;
//        } else {
//            TreeNode tmp = root.right;
//            while (null != tmp.left) {
//                tmp = tmp.left;
//            }
//            tmp.left = root.left;
//            tmp.right = root.right;
//            return tmp;
//        }
//    }

    public static void main(String[] ags) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(6, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(4, treeNode2, treeNode3);

        System.out.println("Traverse.inorderTraverse");
        Traverse.inorderTraverse(treeNode1);
        DeleteNodeinaBST450 deleteNodeinaBST450 = new DeleteNodeinaBST450();
        deleteNodeinaBST450.deleteNode(treeNode1, 4);
        System.out.println("Traverse.inorderTraverse");
        Traverse.inorderTraverse(treeNode1);
    }

}
