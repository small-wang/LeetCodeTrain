package com.ww.leetcode.tree.base;

/**
 * @since 2022/6/11 14:31
 */
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Node{");
        sb.append("val=").append(val);
        sb.append(", next=").append(next == null ? null : next.val);
        sb.append('}');
        return sb.toString();
    }
}
