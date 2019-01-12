package Algorithm.Offer.T15;

import Algorithm.commons.ListNode;
import Algorithm.commons.ListNodeUtil;


/**
 * @Auther gongfukang
 * @Date 1/12 19:37
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        ListNode head = new ListNodeUtil().createListNode(arr);
        new ListNodeUtil().displayList(head);
        new ListNodeUtil().displayList(ReverseList_II(head));
    }

    /**
     * 迭代：三个指针，分别是 pre、cur、next
     * 1. 每次 c->p
     * 2. p、c、n 三个平行推进
     */
    public static ListNode ReverseList_I(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归
     * 1. 递归终止条件：节点为 null
     * 2. 将每个节点断开，保存 next 节点信息
     * 3. next.next -> head
     * 4. 返回 newHead
     */
    public static ListNode ReverseList_II(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseList_II(next);
        next.next = head;
        return newHead;
    }
}
