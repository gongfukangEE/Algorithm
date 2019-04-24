package Algorithm.LeetCode.DynamicProgramming.T70;

/**
 * @auther G.Fukang
 * @date 4/21 23:02
 */
public class Solution {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int res1 = 1;
        int res2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = res1 + res2;
            res1 = res2;
            res2 = res;
        }
        return res;
    }
}
