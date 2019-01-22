package Algorithm.LeetCode.Topic.Fib;

/**
 * @Auther gongfukang
 * @Date 6/19 22:09
 * 记忆化搜索：自上而下
 */
public class Solution {

    public static int[] memo;

    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (memo[n] == 0) {
            memo[n] = fib(n - 1) + fib(n - 2);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 40;
        memo = new int[n + 1];
        System.out.println(fib(n));
    }
}
