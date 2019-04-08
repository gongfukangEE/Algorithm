package Algorithm.LeetCode.Search.BFS.T279M;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther G.Fukang
 * @date 4/8 12:25
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }

    /**
     * 将每个数字看作图中的一个点，如果两个数字直接差值为完全平方数，则两点之间存在边，权值为完全平方数
     * 目的就是找到点 n 到 0 的最短路径
     *
     * @author G.Fukang
     * @date: 4/8 13:57
     */
    public int numSquares(int n) {
        // 建立平方数数组
        int suart = (int)Math.sqrt(n);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= suart; i++) {
           list.add(i * i);
        }
        // 建立图
        int[] graph = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = i;
        }

        // 禁忌表
        boolean[] marked = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        // 从 n 点开始寻找
        queue.add(n);
        marked[n] = true;
        int resCount = 0;
        while (!queue.isEmpty()) {
            resCount++;
            int size = queue.size();
            while (size-- > 0) {
                // 删除点
                int cur = queue.poll();
                for (Integer item : list) {
                    int next = cur - item;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return resCount;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    // 添加点
                    queue.add(next);
                    // 标记点
                    marked[next] = true;
                }
            }
        }
        return n;
    }
}
