package Algorithm.LeetCode.List.T206;

import Algorithm.commons.ListNode;

/**
 * @auther G.Fukang
 * @date 3/20 10:38
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode preNode, curNode, nextNode;
        preNode = null;
        curNode = head;
        nextNode = head;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    public ListNode reverseList_II(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tempNode = head.next;
        head.next = null;
        ListNode newHead = reverseList_II(tempNode);
        tempNode.next = head;
        return newHead;
    }
}
