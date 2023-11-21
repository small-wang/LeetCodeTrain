package com.ww.leetcode.tree.base;

import java.util.Objects;

/**
 * @since 2022/6/11 13:31
 */
public class TreeNode {

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int val;
    public TreeNode left;
    public TreeNode right;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TreeNode{");
        sb.append("val=").append(val);
        sb.append('}');
        return sb.toString();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TreeNode treeNode = (TreeNode) o;
//        return val == treeNode.val;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(val);
//    }
}
