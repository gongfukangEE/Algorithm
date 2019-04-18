package Algorithm.LeetCode.List.T19M;

import Algorithm.commons.ListNode;

/**
 * @auther G.Fukang
 * @date 4/16 21:25
 */
public class Solution {

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
