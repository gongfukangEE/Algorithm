package Algorithm.LeetCode.Search.DFS.T547M;

/**
 * @auther G.Fukang
 * @date 4/8 17:12
 */
public class Solution {

    private int rows, cols;
    private int[][] next = {{0, 1}, {0 ,-1}, {1, 0}, {-1, 0}};
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        this.rows = M.length;
        this.cols = M[0].length;
        int resCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (M[i][j] == 1) {
                    dfs(M, i, j);
                    ++resCount;
                }
            }
        }
        return resCount;
    }

    private void dfs(int[][] M, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || M[row][col] == 0) {
            return;
        }
        // 标记已访问
        M[row][col] = 0;
        for (int[] item : next) {
            dfs(M, row + item[0], col + item[1]);
        }
    }
}
