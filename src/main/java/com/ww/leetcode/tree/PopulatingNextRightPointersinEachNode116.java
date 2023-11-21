package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Node;
import com.ww.leetcode.tree.base.Traverse;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @since 2022/6/11 14:30
 */
public class PopulatingNextRightPointersinEachNode116 {


    public static Node connect(Node root) {
        if (null == root) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    Node nodeNext = queue.peek();
                    node.next = nodeNext;
                }

                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] ags) {
        Node treeNode7 = new Node(7);
        Node treeNode6 = new Node(6);
        Node treeNode5 = new Node(5);
        Node treeNode4 = new Node(4);
        Node treeNode3 = new Node(3, treeNode6, treeNode7);
        Node treeNode2 = new Node(2, treeNode4, treeNode5);
        Node treeNode1 = new Node(1, treeNode2, treeNode3);

        System.out.println("levelTraverse:");
        Traverse.levelTraverse(treeNode1);
        Node inverTreeNode = connect(treeNode1);
        System.out.println("levelTraverse:");
        Traverse.levelTraverse(inverTreeNode);
    }
}
