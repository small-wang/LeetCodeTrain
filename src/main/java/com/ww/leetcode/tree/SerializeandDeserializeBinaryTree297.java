package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Traverse;
import com.ww.leetcode.tree.base.TreeNode;

/**
 * @since 2022/6/14 14:14
 */
// TODO
public class SerializeandDeserializeBinaryTree297 {

    private static final String SEP = ",";
    private static final String NULL = "#";
    private static final StringBuffer BUFFER = new StringBuffer();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) {
            BUFFER.append(NULL).append(SEP);
            return NULL;
        }
        BUFFER.append(root.val).append(SEP);
        serialize(root.left);
        serialize(root.right);
        return BUFFER.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (null == data || data.isEmpty()) {
            return null;
        }
        String[] split = data.split(SEP);
        int[] index = new int[1];
        index[0] = 0;
        return deserialize(split, index);
    }

    // TODO
    private TreeNode deserialize(String[] split, int[] i) {
        if (illegal(split[i[0]])) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(split[i[0]]));
        i[0]++;
        System.out.println(i[0]);
        TreeNode left = deserialize(split, i);
        TreeNode right = deserialize(split, i);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }

    private boolean illegal(String s) {
        if (null == s || s.isEmpty() || NULL.equals(s))
            return true;
        else
            return false;
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
        SerializeandDeserializeBinaryTree297 serializeandDeserializeBinaryTree297 = new SerializeandDeserializeBinaryTree297();
        String serialize = serializeandDeserializeBinaryTree297.serialize(treeNode1);
        System.out.println("serialize:" + serialize);
        TreeNode root = serializeandDeserializeBinaryTree297.deserialize(serialize);
        System.out.println("levelTraverse:");
        Traverse.levelTraverse(root);
//        System.out.println("levelTraverse:");
//        Traverse.levelTraverse(inverTreeNode);
    }
}
