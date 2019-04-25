package Algorithm.LeetCode.DynamicProgramming.Package.T322M;

import java.util.Arrays;

/**
 * @auther G.Fukang
 * @date 4/24 20:52
 */
public class Solution {


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new Solution().coinChange(coins, amount));
    }

    /**
     * 定义一维数组，dp[i] 表示面额为 i 所需要最少的硬币数量
     * 1. 取第 i 个硬币 dp[i] = dp[i - coins[i]] + 1
     * 2. 不取第 i 个硬币 dp[i] = dp[i]
     *  dp[i] = Math.max{dp[i], do[i - coins[i] + 1]}
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.sort(coins);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
