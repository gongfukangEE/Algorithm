package Algorithm.LeetCode.List.T24M;

import Algorithm.commons.ListNode;

/**
 * @auther G.Fukang
 * @date 4/16 21:53
 */
public class Solution {

    /**
     * pre, node1, node2 三个节点
     * node1, node2 交换，再与 pre 连接
     * pre 平行推进
     *
     * @author G.Fukang
     * @date: 4/16 22:34
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode newHead = pre;
        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            node1.next = node2.next;
            node2.next = node1;
            pre.next = node2;

            pre = node1;
        }
        return newHead.next;
    }
}
