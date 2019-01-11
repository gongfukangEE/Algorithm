package Algorithm.LeetCode.T92;

import Algorithm.commons.ListNode;
import Algorithm.commons.ListNodeUtil;

/**
 * @Auther gongfukang
 * @Date 6/16 9:41
 */
public class Solution {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode pre = null;
        ListNode cur = head;
        ListNode left = null;
        ListNode leftP = null;
        while (cur != null) {
            ListNode Next = cur.next;
            count++;
            if (count == m - 1) {
                leftP = cur;
                leftP.next = null;
            }
            if (count == n + 1) {
                left.next = cur;
            }
            if (count >= m && count <= n) {
                cur.next = pre;
                if (count == m) {
                    left = cur;
                }
                if (count == n) {
                    leftP.next = cur;
                }
            }
            pre = cur;
            cur = Next;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        listNodeUtil.displayList(listNodeUtil.createListNode(arr));
        ListNode head = listNodeUtil.createListNode(arr);
        listNodeUtil.displayList(reverseBetween(head, 3, 7));
    }
}
