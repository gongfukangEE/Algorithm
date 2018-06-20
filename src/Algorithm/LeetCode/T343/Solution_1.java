package Algorithm.LeetCode.T343;

/**
 * @Auther gongfukang
 * @Date 6/20 16:53
 * 记忆化搜索
 */
public class Solution_1 {

    private static int res = -1;
    private static int[] memo;

    public static int integerBreak(int n) {
        memo = new int[n + 1];
        return breakInteger(n);
    }

    /**
     * 将 n 进行分割（至少分割两部分），可以获得的最大乘积
     */
    private static int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != 0){
            return memo[n];
        }
        // 分割成 i + (n - i)
        for (int i = 1; i <= n - 1; i++) {
            res = max(res, i * (n - i), i * breakInteger(n - i));
        }
        memo[n] = res;
        return res;
    }

    private static int max (int a, int b, int c) {
        int temp = a > b ? a : b;
        return temp > c ? temp : c;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }
}
