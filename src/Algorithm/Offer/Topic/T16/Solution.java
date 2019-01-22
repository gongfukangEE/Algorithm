package Algorithm.Offer.Topic.T16;

import Algorithm.commons.ListNode;

/**
 * @Auther gongfukang
 * @Date 1/12 21:15
 */
public class Solution {

    /**
     * 迭代
     */
    public static ListNode Merge_I(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }

    /**
     * 递归
     */
    public static ListNode Merge_II(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            Merge_II(list1.next, list2);
            return list1;
        } else {
            Merge_II(list1, list2.next);
            return list2;
        }
    }
}
