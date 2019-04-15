package Algorithm.LeetCode.Search.Backtracking.T79M;

/**
 * @auther G.Fukang
 * @date 4/11 14:22
 */
public class Solution {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new Solution().exist(board, word));
    }

    private static final int[][] direct = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows, cols;
    private boolean[][] marked;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        this.rows = board.length;
        this.cols = board[0].length;
        this.marked = new boolean[rows][cols];
        for (int i = 0;i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (doExist(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean doExist(char[][] board, String word, int i, int j, int index) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(index) || marked[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        // 标记已访问
        marked[i][j] = true;
        // 递归
        for (int[] item : direct) {
            if (doExist(board, word, i + item[0], j + item[1], index + 1)) {
                return true;
            }
        }
        // 取消标记
        marked[i][j] = false;
        return false;
    }
}
