package Algorithm.Offer.Topic.T14;

import Algorithm.commons.ListNode;
import Algorithm.commons.ListNodeUtil;

/**
 * @Auther gongfukang
 * @Date 1/12 16:30
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        ListNode head = new ListNodeUtil().createListNode(arr);
        new ListNodeUtil().displayList(head);
        System.out.println(FindKthToTail(head, 20).val);
    }

    /**
     * 1. 两个指针，P1 指向 head，然后向后移动 k 个节点
     * 2. 这时候 P2 指向 head，然后跟这 P1 一块移动
     * 3. 当 P1 移动到末尾时，P2 指向的就是倒数第 K 个节点
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode pre1 = head;
        ListNode pre2 = head;
        int count = 1;
        while (pre1.next != null) {
            pre1 = pre1.next;
            ++count;
            if (count > k) {
                pre2 = pre2.next;
            }
        }
        if (count < k) {
            return null;
        } else {
            return pre2;
        }
    }
}
