package Algorithm.Offer.T54;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther gongfukang
 * @Date 1/21 15:24
 */
public class Solution {

    /**
     * 1. int[256] 标记字符出现的次数
     * 2. queue 将输入流的字符入队
     * 3. 出现次数大于 1 的字符出队
     * 4. 队列为空，无不重复；队列不为空，输出队头
     */
    private int[] nums = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        nums[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && nums[queue.peek()] > 1) {
            queue.poll();
        }
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
