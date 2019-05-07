package Algorithm.LeetCode.Topic;

/**
 * @auther G.Fukang
 * @date 5/7 16:57
 */
public class T62M {

    /**
     * 动态规划
     * dp[i][j] 表示到达位置 [i][j] 最多有多少路径
     * 由于只能向右或者下移动，dp[i][j] 的路径为从上面到达的路径 dp[i][j - 1] 与 从左面到达的路径 dp[i - 1][j] 之和
     * 则 dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        // 初始化第一行，第一行只能依次向右走，所以只有 1 中路径
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 初始化第一列，第一列只能依次向下走，所以只有 1 中路径
        for (int j = 0; j < m; j++) {
            dp[j][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
