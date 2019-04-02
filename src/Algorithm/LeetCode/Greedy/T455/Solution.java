package Algorithm.LeetCode.Greedy.T455;

import java.util.Arrays;

/**
 * @auther G.Fukang
 * @date 4/2 15:01
 */
public class Solution {


    /**
     * 优先满足胃口值小的孩子
     * @author G.Fukang
     * @date: 4/2 15:35
     */
    public int findContentChildren(int[] g, int [] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
