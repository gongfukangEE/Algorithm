package Algorithm.LeetCode.Topic.T206;

import Algorithm.commons.ListNode;
import Algorithm.commons.ListNodeUtil;

/**
 * @Auther gongfukang
 * @Date 6/15 21:30
 */
public class Solution {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode Next = cur.next;
            // 移动三个指针
            cur.next = pre;
            pre= cur;
            cur = Next;
        }
        // pre 指向新链表的头节点
        return pre;
    }

    public static void main(String[] args) {

        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr = {1,2,3,4,5};
        listNodeUtil.displayList(listNodeUtil.createListNode(arr));
        System.out.println();
        listNodeUtil.displayList(reverseList(listNodeUtil.createListNode(arr)));
    }
}
