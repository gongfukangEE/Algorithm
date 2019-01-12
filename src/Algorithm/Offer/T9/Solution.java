package Algorithm.Offer.T9;

import java.util.Arrays;

/**
 * @Auther gongfukang
 * @Date 1/12 10:53
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(JumpFloorII_I(3));
    }

    /**
     * 动态规划
     */
    public static int JumpFloorII_I(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }

    /**
     * 1. 青蛙跳到第 n 个台阶，则第 n 个台阶是必然存在的
     * 2. 对于剩下的 n-1 个台阶，存在跳和不跳两种可能性
     * 3. 总数为 2^(n-1)
     */
    public static int JumpFloorII_II(int target) {
        return 1 << (target - 1);
    }
}
