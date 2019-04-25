package Algorithm.LeetCode.DynamicProgramming.Package;

/**
 * @auther G.Fukang
 * @date 4/24 19:29
 */
public class Solution {

    /**
     * 0-1 背包问题
     * 定义一个二维数组 dp[i][j] 表示前 i 件物品，不超过体积 j 的最大价值
     *  1. 第 i 件商品不添加 dp[i][j] = dp[i - 1][j]
     *  2. 第 i 件商品添加 dp[i][j] = dp[i - 1][j - v] + w，第 i 件商品的体积为 v，价值为 w
     * dp[i][j] = Max{dp[i - 1][j], dp[i - 1][j - v] + w}
     */
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i<= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j > weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    /**
     * 空间优化
     * 前 i 件物品的状态仅与前 i - 1 件物品的状态有关，因此可以将 dp 定义为一维数组，其中 dp[j] 即可以表示为，因此将 dp 定义为一维数组
     *      dp[j] = Max{dp[j], dp[j - w] + v}
     *  由于 dp[j - w] 表示 dp[i - 1][j - w]，因此不能先求 dp[i][j - w]，防止将 dp[i - 1][j - w] 覆盖
     */
    public int knapsack_II(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = W; j >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }

        return dp[W];
    }
}
