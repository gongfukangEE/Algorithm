package Algorithm.LeetCode.Topic;

/**
 * @auther G.Fukang
 * @date 5/7 17:09
 */
public class T64M {

    /**
     * 动态规划
     * dp[i][j] 表示达到位置 i j 的路径总和最小值
     * dp[i][j] = Min{dp[i - 1][j], dp[i][j - 1]} + grid[i][j]
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 && grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // 初始化第一个位置
        dp[0][0] = grid[0][0];
        // 初始化第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 初始化第一列
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }

        // 寻找路径
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
