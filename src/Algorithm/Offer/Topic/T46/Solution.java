package Algorithm.Offer.Topic.T46;

import java.util.ArrayList;

/**
 * @Auther gongfukang
 * @Date 1/20 19:32
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().LastRemaining_Solution(5, 3));
    }

    /**
     * 链表模拟环
     * 1. count 从 0 开始，每隔 m - 1 删除一个元素
     * 2. count=(count+m-1)%list.size 模拟环，记录下一个 m-1 元素在当前链表的位置
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int count = 0;
        while (list.size() > 1) {
            count = (count + m - 1) % list.size();
            list.remove(count);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }

    /**
     * 数组模拟链表
     * 1. i 为每次可以报数的人序号，当i=n时，i=0来模拟环，i 所有人都走
     * 2. count 为人总数，每出去一个，count--，且数组值置 -1
     * 3. step 为报的数，step=m时，标记出去的人&重置，step 只走可以报数的人
     */
    public int LastRemaining_Solution_I(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        int[] arr = new int[n];
        int i = -1, count  = n, step = 0;
        while (count > 0) {
            if (++i >= n) {
                i = 0;
            }
            if (arr[i] == -1) {
                continue;
            }
            if (++step == m) {
                arr[i] = -1;
                step = 0;
                --count;
            }
        }
        return i;
    }
}
