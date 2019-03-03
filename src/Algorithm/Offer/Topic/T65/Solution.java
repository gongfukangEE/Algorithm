package Algorithm.Offer.Topic.T65;

/**
 * @Auther gongfukang
 * @Date 1/22 13:12
 */
public class Solution {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[][] target = {{'b', 'c', 'c', 'e', 'e'}, {'a', 'b', 'c', 'b'}};
        System.out.println(new Solution().hasPath(arr, 3, 4, target[0]));
    }


    /**
     * 深度优先搜索
     *
     * @author G.Fukang
     * @date: 3/3 16:43
     */
    private int rows;
    private int cols;
    private boolean[][] mark;
    private char[] str;
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.rows = rows;
        this.cols = cols;
        this.str = str;
        char[][] wordMatrix = buildMatrix(matrix);
        this.mark = new boolean[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (dfs(wordMatrix,i, j, 0))
                    return true;
        return false;
    }

    private boolean dfs(char[][] wordMatrix,int row, int col, int index) {
        if (str.length == index)
            return true;
        if (row < 0 || col < 0 || row >= wordMatrix.length || col >= wordMatrix[0].length) {
            return false;
        }
        char ch = str[index];
        if (!mark[row][col] && ch == wordMatrix[row][col]) {
            mark[row][col] = true;
            for (int[] item : next)
                if (dfs(wordMatrix,row + item[0], col + item[1], index + 1))
                    return true;
            mark[row][col] = false;
            return false;
        }
        return false;
    }

    private char[][] buildMatrix(char[] matrix) {
        char[][] wordMatrix = new char[rows][cols];
        int index = -1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                wordMatrix[i][j] = matrix[++index];
        return wordMatrix;
    }
}
