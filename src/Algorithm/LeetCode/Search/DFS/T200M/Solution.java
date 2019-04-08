package Algorithm.LeetCode.Search.DFS.T200M;



/**
 * @auther G.Fukang
 * @date 4/8 15:28
 */
public class Solution {

    private boolean[][] marked;
    private int rows, cols;
    private int[][] next = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // 禁忌表
        this.marked = new boolean[grid.length][grid[0].length];
        this.rows = grid.length;
        this.cols = grid[0].length;
        // 岛屿数量
        int resCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !marked[i][j]) {
                    dfs(grid, i, j);
                    resCount++;
                }
            }
        }
        return resCount;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || marked[row][col] || grid[row][col] == '0') {
            return;
        }
        marked[row][col] = true;
        for (int[] item : next) {
            dfs(grid, row + item[0], col + item[1]);
        }
    }
}
