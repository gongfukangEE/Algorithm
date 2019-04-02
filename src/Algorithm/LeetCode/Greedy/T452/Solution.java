package Algorithm.LeetCode.Greedy.T452;

import java.util.Arrays;

/**
 * @auther G.Fukang
 * @date 4/2 16:02
 */
public class Solution {

    /**
     * 计算不重叠区间的个数
     *
     * @author G.Fukang
     * @date: 4/2 16:23
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> (o1[1] - o2[1]));
        int count = 1;
        int xEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > xEnd) {
                count++;
                xEnd = points[i][1];
            }
        }
        return count;
    }
}
