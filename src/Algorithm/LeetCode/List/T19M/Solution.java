package Algorithm.LeetCode.List.T19M;

import Algorithm.commons.ListNode;

/**
 * @auther G.Fukang
 * @date 4/16 21:25
 */
public class Solution {

    /**
     * 快慢指针
     * 快指针先走到第 n 个节点，然后快慢指针一块走
     * 快指针走到链表末尾，慢指针的下一个节点就是要删除的节点
     * 边界问题：
     *      链表长度小于 n
     *      链表长度等于 n    直接返回头节点的 next 节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
