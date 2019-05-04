package Algorithm.LeetCode.List.T23H;

import Algorithm.commons.ListNode;

import java.util.PriorityQueue;

/**
 * @auther G.Fukang
 * @date 5/4 20:15
 */
public class Solution {

    /**
     * 最小堆
     */
    public ListNode mergeKLists_II(ListNode[] lists) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        if (lists.length == 0 ) {
            return cur.next;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        while (!minHeap.isEmpty()) {
            // 取出堆顶元素
           ListNode node = minHeap.poll();
           // 将堆顶元素加入链表
            cur.next = node;
            // 将 node 的下一个元素加入堆中
            if (node.next != null) {
                minHeap.add(node.next);
            }
            cur = cur.next;
        }

        return res.next;
    }

    /**
     * 分治
     * 简单来说就是不停的对半划分，比如k个链表先划分为合并两个k/2个链表的任务，
     * 再不停的往下划分，直到划分成只有一个或两个链表的任务，开始合并
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int length = lists.length;
        while (length > 1) {
            int k = (length + 1) / 2;
            for (int i = 0; i < length / 2; i++) {
                lists[i] = merge2List(lists[i], lists[i + k]);
            }
            length = k;
        }
        return lists[0];
    }

    private ListNode merge2List(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                break;
            }
            if (l2 == null) {
                cur.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return res.next;
    }
}
