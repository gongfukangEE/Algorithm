package Algorithm.LeetCode.Topic.Fib;

/**
 * @Auther gongfukang
 * @Date 6/19 22:28
 * 动态规划：自下而上
 */
public class Solution_2 {

    public static int[] memo;

    public static int fib(int n) {
        memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++)
            memo[i] = memo[i - 1] + memo[i - 2];
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 40;
        System.out.println(fib(n));
    }
}
