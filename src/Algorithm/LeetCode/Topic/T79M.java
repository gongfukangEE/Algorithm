package Algorithm.LeetCode.Topic;

/**
 * @auther G.Fukang
 * @date 5/10 19:44
 */
public class T79M {

    /**
     * dfs
     * 每次字母向四个方向移动，一旦匹配上一个字符，就从当前字符的位置继续向四个方向移动
     * 在移动过程中，为避免重复，将走过的字符标记上
     */
    // 字母移动的四个方向
    private final int[][] directs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] marked;
    private int rows, cols;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        this.rows = board.length;
        this.cols = board[0].length;
        this.marked = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // 索引超出左右上下边界 || 当前位置的字符和 word 的字符不匹配 || 当前位置字符已经被标记过
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(index) || marked[i][j]) {
            return false;
        }
        // 匹配到最后一个字符
        if (index == word.length() - 1) {
            return true;
        }
        // 标记元素
        marked[i][j] = true;
        // dfs
        for (int[] direct : directs) {
            // 只要一个匹配上，就是 true
            if (dfs(board, word, i + direct[0], j + direct[1], index + 1)) {
                return true;
            }
        }
        // 取消标记
        marked[i][j] = false;
        return false;
    }
}
