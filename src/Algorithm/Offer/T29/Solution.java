package Algorithm.Offer.T29;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther gongfukang
 * @Date 1/18 16:46
 */
public class Solution {

    /**
     * 最小 K 个数，使用最小堆
     * 1. 应该使用一个大顶堆来维护一个最小堆，插入一个数，如果堆的大小超过 k，则移除堆顶元素
     * 2. PriorityQueue 默认是小顶堆，通过 Override Comparator 来实现大顶堆
     * 3. 边界条件（K 超时 || 数组为空 || k=0）
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length || k == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int item : input) {
            maxHeap.add(item);
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
