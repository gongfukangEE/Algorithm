package Algorithm.LeetCode.Topic;

import Algorithm.commons.ListNode;

/**
 * @auther G.Fukang
 * @date 5/18 21:21
 */
public class T160 {

    /**
     * 双链表
     * 1. 链表 p1 和 链表 p2 分别从两个 head 开始走
     * 2. p1 走到尾节点时，从 headB 重新走
     * 3. p2 走到尾节点时，从 headA 重新走
     * 4. p1 和 p2 相遇的节点就是第一个相交的节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
