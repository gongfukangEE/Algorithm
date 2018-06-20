package Algorithm.LeetCode.T70;

/**
 * @Auther gongfukang
 * @Date 6/20 16:18
 * 递归实现
 */
public class Solution_1 {
    public static int climbStairs(int n) {
        return calcWays(n);
    }

    private static int calcWays(int n) {
        if (n == 1 || n == 0)
            return 1;
        return calcWays(n - 1) + calcWays(n - 2);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }
}
