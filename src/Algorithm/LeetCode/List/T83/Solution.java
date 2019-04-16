package Algorithm.LeetCode.List.T83;

import Algorithm.commons.ListNode;

/**
 * @auther G.Fukang
 * @date 4/16 20:17
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            int val = curNode.val;
            while (curNode.next != null && curNode.next.val == val) {
                curNode.next = curNode.next.next;
            }
            curNode = curNode.next;
        }
        return head;
    }
}
