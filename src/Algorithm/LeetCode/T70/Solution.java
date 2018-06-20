package Algorithm.LeetCode.T70;

/**
 * @Auther gongfukang
 * @Date 6/20 16:39
 */
public class Solution {

    private static int[] memo;

    public static int climbStairs(int n) {
        memo = new int[n + 1];

        if (n == 0 || n == 1)
            memo[n] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(n);
    }
}
