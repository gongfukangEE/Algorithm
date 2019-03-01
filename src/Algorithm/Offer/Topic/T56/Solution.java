package Algorithm.Offer.Topic.T56;

import Algorithm.commons.ListNode;
import Algorithm.commons.ListNodeUtil;

/**
 * @Auther gongfukang
 * @Date 1/21 16:56
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,4,4,4,7};
        ListNodeUtil util = new ListNodeUtil();
        ListNode head = util.createListNode(arr);
        util.displayList(head);
        util.displayList(new Solution().deleteDuplication(head));
    }

    /**
     * 1. 0 || 1 个节点，直接返回
     * 2. 当前节点是重复节点，while 删除，然后从第一个与当前节点不同的节点开始递归
     * 3. 当前节点不是重复节点，保留节点递归
     * Tips:
     * 1->4->4->4->7
     *      1) 1->4,运行到 41 行，传入为 4
     *      2) 4 运行后，node 为 7，也就说 deleteDuplication(pHead.next) 返回值为 7
     *      3) 返回 7 后，1->7
     *      4) 第一个 4 在入参时就被去掉了，第二三个 4 在 while 中被去掉
     * @author G.Fukang
     * @date: 1/23 17:44
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        if (pHead.val == pHead.next.val) {
            ListNode node = pHead.next;
            while (node != null && pHead.val == node.val) {
                node = node.next;
            }
            return deleteDuplication(node);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public ListNode deleteDuplication_I(ListNode pHead) {
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode slow = newHead;
        ListNode fast = pHead;
        while(fast != null && fast.next != null) {
            if (fast.val == fast.next.val) {
                int value = fast.val;
                while(fast != null && fast.val == value)
                    fast = fast.next;
                slow.next = fast;
            } else {
                slow = fast;
                fast = fast.next;
            }
        }
        return newHead.next;
    }
}
