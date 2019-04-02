package Algorithm.LeetCode.List.T21;

import Algorithm.commons.ListNode;


/**
 * @auther G.Fukang
 * @date 3/20 11:24
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode newHead = new ListNode(-1);
        ListNode curNode = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        curNode.next = l1 == null ? l2 : l1;
        return newHead.next;
    }
}
