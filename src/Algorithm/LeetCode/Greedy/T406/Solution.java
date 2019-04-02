package Algorithm.LeetCode.Greedy.T406;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @auther G.Fukang
 * @date 4/2 16:30
 */
public class Solution {

    /**
     * 1、排序：身高高 -> 低，身高相同 K 小 -> 大
     * 2、插入链表的指定位置
     *
     * @author G.Fukang
     * @date: 4/2 17:17
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people,(o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        ArrayList<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
