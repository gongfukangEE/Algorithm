package Algorithm.LeetCode.Topic;

import java.util.Collections;

/**
 * @auther G.Fukang
 * @date 5/6 19:24
 */
public class T48M {

    /**
     * 1. 沿着副对角线交换元素
     * 2. 沿着中间水平线交换元素
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        // 副对角线交换元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }

        // 中间水平线交换元素
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
    }
}
