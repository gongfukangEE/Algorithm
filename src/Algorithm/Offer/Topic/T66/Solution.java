package Algorithm.Offer.Topic.T66;

/**
 * @Auther gongfukang
 * @Date 1/22 15:09
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(15, 20, 20));
    }

    private int count = 0;
    boolean[][] mark;
    private int rows;
    private int cols;
    private int threshold;
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int movingCount(int threshold, int rows, int cols) {
        int[][] matrix = buildSumMatrix(rows, cols);
        this.rows = rows;
        this.cols = cols;
        this.mark = new boolean[rows][cols];
        this.threshold = threshold;
        dfs(matrix, 0, 0);
        return count;
    }

    private void dfs(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || mark[row][col])
            return;
        mark[row][col] = true;
        if (matrix[row][col] > threshold)
            return;
        count++;
        for (int[] item : next)
            dfs(matrix, row + item[0], col + item[1]);
    }


    private int[][] buildSumMatrix(int rows, int cols) {
        int[] sumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < sumOne.length; i++) {
            int t = i;
            while (t > 0) {
                sumOne[i] += t % 10;
                t /= 10;
            }
        }
        int[][] sumMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                sumMatrix[i][j] = sumOne[i] + sumOne[j];
        return sumMatrix;
    }
}
