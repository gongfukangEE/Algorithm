package Algorithm.LeetCode.Topic;


/**
 * @auther G.Fukang
 * @date 5/22 20:16
 */
public class T240 {

    /**
     * 从左下角开始找，如果小于当前值，则向上找，大于当前值则向右找
     * 暴力超时，边界条件需要一次性全部判断
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int startRow = rows - 1;
        int startCol = 0;
        while (startRow >= 0 && startCol < cols) {
            int cur = matrix[startRow][startCol];
            if (target > cur) {
                startCol++;
            } else if (target < cur) {
                startRow--;
            } else {
                return true;
            }
        }
        return false;
    }
}
