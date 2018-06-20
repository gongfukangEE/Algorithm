package Algorithm.LeetCode.T79;

/**
 * @Auther gongfukang
 * @Date 6/20 11:36
 */
public class Solution {

    private static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int m,n;
    private static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {
        char[] wordToChar = word.toCharArray();
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchWord(board, wordToChar, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    /**
     * 从 board[startx][starty] 开始，寻找word[index...word.length]
     */
    private static boolean searchWord(char[][] board, char[] word, int index, int startx, int starty) {
        if(index == word.length - 1) {
            return board[startx][starty] == word[index];
        }
        if (board[startx][starty] == word[index]) {
            visited[startx][starty] = true;
            // 从 startx starty 出发，向四个方向寻找
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (inArea(newx, newy) && !visited[newx][newy]) {
                    if(searchWord(board, word, index +1, newx, newy))
                        return true;
                }
            }
            visited[startx][starty] = false;
        }
        return false;
    }

    /**
     * 确保数组未越界
     */
    private static boolean inArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(exist(board, word));
    }
}
