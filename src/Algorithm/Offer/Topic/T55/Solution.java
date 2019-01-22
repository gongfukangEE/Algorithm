package Algorithm.Offer.Topic.T55;

import Algorithm.commons.ListNode;

/**
 * @Auther gongfukang
 * @Date 1/21 16:12
 */
public class Solution {

    /**
     * 双指针，快慢指针
     * 1. 快指针一次走 2 个
     * 2. 慢指针一次走 1 个
     * 3. 链表环前面部分为 x，fast 与 last 相遇在 z 开头，x 与 z 之间的为 y
     * 4. 由于 fast 为 slow 两倍，则 fast 走过一圈半, slow 走不到一圈相遇
     * 5. fast：x+(y+z)+y    ；slow：x+y
     * 6. fast = 2 slow ==> x=z
     * 7. 相遇后，slow 接着走，fast 从头开始走，在环入口再次相遇
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        /**
         * 此处有坑，如果直接写 fast = pHead; slow = pHead
         * while 条件均不成立，输出链表头
         */
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
