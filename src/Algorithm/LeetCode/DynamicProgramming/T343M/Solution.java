package Algorithm.LeetCode.DynamicProgramming.T343M;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @auther G.Fukang
 * @date 4/24 9:56
 */
public class Solution {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(new Solution().integerBreak(n));
    }

    /**
     * 全部拆成 2 和 3
     */
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int res = 1;
        while (n > 4) {
           res *= 3;
           n -= 3;
        }
        return res * n;
    }
}
