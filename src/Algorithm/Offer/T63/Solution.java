package Algorithm.Offer.T63;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther gongfukang
 * @Date 1/21 22:26
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {5,2,3,4,1,6,7,0,8};
        Solution solution = new Solution();
        for (int item : nums) {
            solution.Insert(item);
            System.out.println(solution.GetMedian());
        }
    }

    /**
     * 小顶堆（右边元素） + 大顶堆（左边元素） （大顶堆的堆顶小于小顶堆的堆顶）
     * 1. 分为奇数和偶数
     * 2. 偶数：新加入的元素进行大顶堆，筛选出最大的元素进入小顶堆
     * 3. 奇数：新加入的元素进入小顶堆，筛选出最小的元素进入大顶堆
     * 4. 奇数和偶数进行大顶堆还是小顶堆无关，均满足过滤，但是
     *     奇数进入大顶堆，返回中位数为 maxHeap.peek()
     *     奇数进入小顶堆，返回中位数为 minHeap.peek()
     */
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private int count = 0;

    public void Insert(Integer num) {
        if (count % 2 != 0) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
        ++count;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double) minHeap.peek();
        }
    }
}
