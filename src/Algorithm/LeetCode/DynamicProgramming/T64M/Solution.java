package Algorithm.LeetCode.DynamicProgramming.T64M;

/**
 * @auther G.Fukang
 * @date 4/23 22:32
 */
public class Solution {

    public static void main(String[] args) {
        int[][] grod = {{1,3,1},{1,5,1}};
        System.out.println(new Solution().minPathSum(grod));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        // 求第一行的值
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 求第一列的值
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }

        // 从上到下求解
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int minPathSum_II(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    // 左边界，只能从上面走到这里
                    dp[j] = dp[j];
                } else if (j == 0) {
                    // 上边界，只能从右边走到这里
                    dp[j] = dp[j - 1];
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
