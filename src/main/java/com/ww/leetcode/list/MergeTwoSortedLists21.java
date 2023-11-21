package com.ww.leetcode.list;

import com.ww.leetcode.list.base.ListNode;

/**
 * @since 2022/10/19 9:08
 */
public class MergeTwoSortedLists21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while(null != list1 && null != list2) {
            if(list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if(null == list1) {
            p.next = list2;
        }

        if(null == list2) {
            p.next = list1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode3;
        listNode3.next = listNode5;
        listNode2.next = listNode4;
        listNode4.next = listNode6;

        MergeTwoSortedLists21 mergeTwoSortedLists21 = new MergeTwoSortedLists21();
        ListNode listNode = mergeTwoSortedLists21.mergeTwoLists(listNode1, listNode2);
        while(null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
