package Algorithm.Offer.T36;

import Algorithm.commons.ListNode;

/**
 * @Auther gongfukang
 * @Date 1/19 15:33
 */
public class Solution {

    /**
     * 1. 链表 1 & 2 同时走
     * 2. 链表 1 走到末尾时再从链表 2  的头部开始走
     * 3. 链表 2 走到末尾时再从链表 1 的头部开始走
     * 4. 两个链表在第一个公共节点相遇
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode curP1 = pHead1;
        ListNode curP2 = pHead2;
        while (curP1 != curP2) {
            if (curP1 == null) {
                curP1 = pHead2;
            } else {
                curP1 = curP1.next;
            }
            if (curP2 == null) {
                curP2 = pHead1;
            } else {
                curP2 = curP2.next;
            }
        }
        return curP1;
    }
}
