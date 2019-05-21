package Algorithm.LeetCode.List.T234;

import Algorithm.commons.ListNode;

/**
 * @auther G.Fukang
 * @date 5/21 21:38
 */
public class Solution {

    /**
     * 1. 快慢链表，找到链表的中间部分
     * 2. 反转后半部分链表
     * 3. 判断回文
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 快指针
        ListNode fast = head;
        // 慢指针
        ListNode slow = head;
        // 慢指针不用判断，直接判断快指针
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半部分
        ListNode reverseHead = reverseList(slow);
        while (head != null && reverseHead != null) {
            if (head.val != reverseHead.val) {
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode node) {
        // 递归结束条件
        if (node == null || node.next == null) {
            return node;
        }
        // 保存后续节点
        ListNode nextNode = node.next;
        // 断开后半部分
        node.next = null;
        // 递归
        ListNode newHead = reverseList(nextNode);
        // 反转
        nextNode.next = node;
        return newHead;
    }
}
