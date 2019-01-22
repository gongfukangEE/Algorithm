package Algorithm.Offer.Topic.T64;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther gongfukang
 * @Date 1/22 10:56
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList list = new Solution().maxInWindows(arr, 3);
        System.out.println(list.toString());
    }

    /**
     * 维护一个大顶堆
     * 窗口滑动一次：左边元素从堆中移除，右边元素入堆，返回堆顶
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> retlist = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if (num == null || size > num.length || size == 0) {
            return retlist;
        }
        for (int i = 0; i < size; i++) {
            maxHeap.add(num[i]);
        }
        retlist.add(maxHeap.peek());
        for (int i = 0; i < num.length - size; i++) {
            maxHeap.remove(num[i]);
            maxHeap.add(num[i + size]);
            retlist.add(maxHeap.peek());
        }
        return retlist;
    }
}
