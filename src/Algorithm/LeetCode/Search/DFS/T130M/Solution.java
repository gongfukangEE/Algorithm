package Algorithm.LeetCode.Search.DFS.T130M;

/**
 * @auther G.Fukang
 * @date 4/8 23:29
 */
public class Solution {

   /**
    * 从外边界上的 O 开始填充，将与外边界 O 相连的 O 全部替换为 T
    * 然后逐个遍历矩阵，如果为 T，变为 O；如果为 O，则变为 X
    *
    * @author G.Fukang
    * @date: 4/9 19:50
    */
   private int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
   private int m, n;
   public void solve(char[][] board) {
      if (board.length == 0 || board[0].length == 0) {
         return;
      }
      m = board.length;
      n = board[0].length;

      for (int i = 0; i < m; i++) {
         dfs(board, i , 0);
         dfs(board, i , n - 1);
      }

      for (int i = 0; i < n; i++) {
         dfs(board, 0 ,i);
         dfs(board, m- 1, i);
      }

      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if (board[i][j] == 'T') {
               board[i][j] = 'O';
            } else if (board[i][j] == 'O') {
               board[i][j] = 'X';
            }
         }
      }
   }

   private void dfs(char[][] board, int i, int j) {
      if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
         return;
      }
      board[i][j] = 'T';
      for (int[] item : next) {
         dfs(board, i + item[0], j + item[1]);
      }
   }
}
