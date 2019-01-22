package Algorithm.LeetCode.Topic.T70;

/**
 * @Auther gongfukang
 * @Date 6/20 16:26
 * 记忆化搜索
 */
public class Solution_2 {

    private static int[] memo;

    public static int climbStairs(int n) {
        memo = new int[n + 1];
        return calcWays(n);
    }

    private static int calcWays(int n) {
        if (n == 0 || n == 1)
           memo[n] = 1;
        if (memo[n] == 0)
            memo[n] = calcWays(n - 1) + calcWays(n -2);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }
}
