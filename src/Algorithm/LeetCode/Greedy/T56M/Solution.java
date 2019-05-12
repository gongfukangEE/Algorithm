package Algorithm.LeetCode.Greedy.T56M;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 5/8 20:49
 */
public class Solution {

    public static void main(String[] args) {
        int[][] nums = new int[][] {{1, 4}, {2, 3}};
        int[][] res = new Solution().merge(nums);
    }

    /**
     * 贪心算法
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[][] {};
        }
        // 按照区间左边界排序
        Arrays.sort(intervals,(o1, o2) -> o1[0] - o2[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end ) {
                // 注意新元素数组与原 start 和 end 的对比
                end = intervals[i][1] >= end ? intervals[i][1] : end;
                start = intervals[i][0] <= start ? intervals[i][0] : start;
            } else {
                // 区间不重叠
                list.add(new int[] {start, end});
                // 更新 start 和 end
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[] {start, end});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
