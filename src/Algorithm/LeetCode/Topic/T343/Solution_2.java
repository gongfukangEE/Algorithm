package Algorithm.LeetCode.Topic.T343;

/**
 * @Auther gongfukang
 * @Date 6/20 19:44
 * 动态规划
 */
public class Solution_2 {

    // memo[i] 表示将数字 i 分割（至少分割成两部分）后得到的最大乘积
    private static int[] memo;

    public static int integerBreak(int n) {
        memo = new int[n + 1];

        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            //求解 memo[i]，尝试将 i 进行分割
            for (int j = 1; j <= i -1; j++) {
                // j + (i - j)
                memo[i] = max(memo[i], j * (i -j), j * memo[i - j]);
            }
        }
        return memo[n];
    }

    private static int max (int a, int b, int c) {
        return (a > b ? a : b) > c ? (a > b ? a : b) : c;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }
}
