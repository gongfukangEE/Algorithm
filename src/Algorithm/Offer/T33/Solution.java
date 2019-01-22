package Algorithm.Offer.T33;

import java.util.ArrayList;

/**
 * @Auther gongfukang
 * @Date 1/18 23:08
 */
public class Solution {

    public static void main(String[] args) {
        int index = 10;
        System.out.println(new Solution().GetUglyNumber_Solution_I(index));
    }

    /**
     * 动态规划
     * p 为丑数，p=2^x * 3^y * 5^z
     * 暴力：由于 1 是最小的丑数，则 2*1,3*1,5*1 中最小的为下一个丑数，此处为 2
     *       比较(2*1,2*3,2*5,3*1,5*1) 中挑出最小的为下一个丑数，即每次挑出最小的为丑数
     * 动态规划：
     * 1. 维护三个队列，*2 队列，*3 队列，*5 队列（用 3 个指针表示 | ）
     * 2.  丑数 1
     *     队列：|2
     *           |3
     *           |5
     *     丑数 1，2
     *     队列：2，|4
     *           |3，6
     *           |5，10
     *     丑数 1，2，3
     *     队列：2，|4，6
     *           3，|6，9
     *           |5，10，15
     * 3. 每次比较指针所指向的数据，取最小
     */
    public int GetUglyNumber_Solution_I(int index) {
        if (index <= 6) {
            return index;
        }
        int[] ret = new int[index];
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list5 = new ArrayList<>();
        ret[0] = 1;
        list2.add(2);
        list3.add(3);
        list5.add(5);
        for (int i = 1; i < index; i++) {
            int next2 = list2.get(0);
            int next3 = list3.get(0);
            int next5 = list5.get(0);
            ret[i] = Math.min(next2, Math.min(next3, next5));
            if (ret[i] == next2) {
                list2.remove(0);
            }
            if (ret[i] == next3) {
                list3.remove(0);
            }
            if (ret[i] == next5) {
                list5.remove(0);
            }
            list2.add(ret[i] * 2);
            list3.add(ret[i] * 3);
            list5.add(ret[i] * 5);
        }
        return ret[index - 1];
    }
    /**
     * 动态规划：将三个链表合并成一个
     */
    public int GetUglyNumber_Solution(int index) {
        if(index <= 6) {
            return index;
        }
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int next2 = dp[i2] * 2;
            int next3 = dp[i3] * 3;
            int next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) {
                i2++;
            }
            if (dp[i] == next3) {
                i3++;
            }
            if (dp[i] == next5) {
                i5++;
            }
        }
        return dp[index - 1];
    }
}
