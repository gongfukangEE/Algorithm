package Algorithm.LeetCode.TwoPonits.T141;

import Algorithm.commons.ListNode;


/**
 * @auther G.Fukang
 * @date 3/14 19:39
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != null && fast != null) {
            if (fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
