package Algorithm.LeetCode.Topic;

import Algorithm.commons.ListNode;
import Algorithm.commons.ListNodeUtil;

/**
 * @auther G.Fukang
 * @date 5/1 19:18
 */
public class T2M {

    public static void main(String[] args) {
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] num1 = {0,8,6,5,6,8,3,5,7};
        int[] num2 = {6,7,8,0,8,5,8,9,7};
        ListNode l1 = listNodeUtil.createListNode(num1);
        ListNode l2 = listNodeUtil.createListNode(num2);

        new T2M().addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null ) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        // 判断进位
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            carry = val >= 10 ? 1 : 0;
            val %= 10;
            // 插入链表
            cur.next = new ListNode(val);
            cur = cur.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode list = new ListNode(-2);
        if (l1 != null) {
            list = l1;
        } else if (l2 != null) {
            list = l2;
        } else if (carry == 1){
            cur.next = new ListNode(carry);
            carry = 0;
            list = null;
        } else {
            list = null;
        }

        // 将剩余的链表接上
        while (list != null) {
            int val = list.val + carry;
            carry = val >= 10 ? 1 : 0;
            val %= 10;
            // 插入链表
            cur.next = new ListNode(val);
            cur = cur.next;
            list = list.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return res.next;
    }
}
