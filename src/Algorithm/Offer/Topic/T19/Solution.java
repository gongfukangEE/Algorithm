package Algorithm.Offer.Topic.T19;

import java.util.ArrayList;

/**
 * @Auther gongfukang
 * @Date 1/13 10:18
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        ArrayList<Integer> matrixPrint = printMatrix(matrix);
        for (Integer item : matrixPrint) {
            System.out.print(item + " ");
        }
    }

    /**
     * 1. 上 -> 右 -> 下 -> 左
     * 2. 注意边界条件，上下边界判定，左右边界判定
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 上面
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            // 右面
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            // 下面
            if (rowEnd != rowStart) {
                for (int i = colEnd - 1; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            // 左面
            if (colEnd != colStart) {
                for (int i = rowEnd - 1; i > rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            ++rowStart;
            ++colStart;
            --rowEnd;
            --colEnd;
        }
        return result;
    }
}
