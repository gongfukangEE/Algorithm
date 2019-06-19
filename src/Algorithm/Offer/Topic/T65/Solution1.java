package Algorithm.Offer.Topic.T65;

/**
 * @Auther gongfukang
 * @Date 1/22 13:12
 */
public class Solution1 {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[][] target = {{'b', 'c', 'c', 'e', 'e'}, {'a', 'b', 'c', 'b'}, {'s', 'e', 'e'}};
        System.out.println(new Solution1().hasPath(arr, 3, 4, target[2]));
    }


    /**
     * 深度优先搜索
     *
     * @author G.Fukang
     * @date: 3/3 16:43
     */
    // 四个方向移动
    private int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0) return false;
        boolean[][] marked = new boolean[rows][cols];
        char[][] resMatrix = buildMatrix(matrix, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (resMatrix[i][j] == str[0]) {
                    if (dfs(resMatrix, i, j, 0, rows, cols, str, marked))   return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, int i, int j, int index, int rows, int cols, char[] target, boolean[][] marked) {
        if (index == target.length) return true;
        if (i < 0 || j < 0 || i >= rows || j >= cols || marked[i][j] || matrix[i][j] != target[index]) return false;
        if (matrix[i][j] == target[index]) {
            // 标记
            marked[i][j] = true;
            // 递归
            for (int[] dir : next) {
                if (dfs(matrix, i + dir[0], j + dir[1], index + 1, rows, cols, target, marked)) return true;
            }
            // 取消标记
            marked[i][j] = false;
            return false;
        }
        return false;
    }

    private char[][] buildMatrix(char[] matrix, int rows, int cols) {
        char[][] wordMatrix = new char[rows][cols];
        int index = -1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                wordMatrix[i][j] = matrix[++index];
        return wordMatrix;
    }
}
