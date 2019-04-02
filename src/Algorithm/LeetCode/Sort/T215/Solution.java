package Algorithm.LeetCode.Sort.T215;

import java.util.PriorityQueue;

/**
 * @auther G.Fukang
 * @date 4/1 22:10
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer item : nums) {
            minHeap.add(item);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
