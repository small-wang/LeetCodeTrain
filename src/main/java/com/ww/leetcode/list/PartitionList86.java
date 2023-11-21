package com.ww.leetcode.list;

import com.ww.leetcode.list.base.ListNode;

/**
 * @since 2022/10/19 9:21
 */
public class PartitionList86 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        while (null != head) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
                ListNode tmp = head.next;
                head.next = null;
                head = tmp;
            } else {
                p2.next = head;
                p2 = p2.next;
                ListNode tmp = head.next;
                head.next = null;
                head = tmp;
            }
        }
        p1.next = dummy2.next;

        return dummy1.next;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        PartitionList86 partitionList86 = new PartitionList86();
        ListNode result = partitionList86.partition(node1, 3);
        while(null != result) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
