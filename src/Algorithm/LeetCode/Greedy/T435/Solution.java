package Algorithm.LeetCode.Greedy.T435;

import java.util.Arrays;
import java.util.Collections;

/**
 * @auther G.Fukang
 * @date 4/2 15:37
 */
public class Solution {


    /**
     *
     * 选择结束时间最短的，然后组成一个不重叠区间，
     * 最后用总个数减去组成不重叠区间所用的个数
     * @author G.Fukang
     * @date: 4/2 16:01
     */
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> (o1.end - o2.end));
        int count = 0;
        int endGlobal = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].start >= endGlobal) {
                count++;
                endGlobal = intervals[i].end;
            }
        }
        return intervals.length - count;
    }
}
