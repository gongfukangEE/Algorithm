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
        return helpMerge(lists, 0, lists.length - 1);
    }
    // 划分链表
    private ListNode helpMerge(ListNode[] lists, int start, int end) {
        if (start > end)	return null;
        if (start == end)	return lists[start];
        int mid = (start + end) / 2;
        ListNode left = helpMerge(lists, start, mid);
        ListNode right = helpMerge(lists, mid + 1, end);
        return merge(left, right);
    }
    // 合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)	return l2;
        if (l2 == null)	return l1;
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
