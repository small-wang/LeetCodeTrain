package com.ww.leetcode.tree;

import com.ww.leetcode.tree.base.Traverse;
import com.ww.leetcode.tree.base.TreeNode;

import java.util.*;

/**
 * @since 2022/6/14 16:01
 */
public class FindDuplicateSubtrees652 {

    private final Map<String, Integer> HASHMAP = new HashMap<>();
    private final List<TreeNode> SET = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (null == root) {
            return null;
        }
        findDuplicateSubtreesStr(root);
        return SET;
    }

    private String findDuplicateSubtreesStr(TreeNode root) {
        if (null == root) {
            return null;
        }

        int val = root.val;
        String left = findDuplicateSubtreesStr(root.left);
        String right = findDuplicateSubtreesStr(root.right);
        String key = val + "," + left + "," + right + ",";
        if (null == HASHMAP.get(key)) {
            HASHMAP.put(key, 1);
        } else {
            HASHMAP.put(key, HASHMAP.get(key) + 1);
            if (2 == HASHMAP.get(key)) {
                SET.add(root);
            }
        }
        return key;
    }

    public static void main(String[] ags) {
        TreeNode treeNode7 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode5, treeNode6);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        treeNode5.left = treeNode7;

        System.out.println("levelTraverse:");
        Traverse.levelTraverse(treeNode1);
        FindDuplicateSubtrees652 flattenBinaryTreetoLinkedList114 = new FindDuplicateSubtrees652();
        List<TreeNode> list = flattenBinaryTreetoLinkedList114.findDuplicateSubtrees(treeNode1);
        System.out.println("list:" + list.toString());
    }
}
