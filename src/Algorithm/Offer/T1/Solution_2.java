package Algorithm.Offer.T1;

/**
 * @Auther gongfukang
 * @Date 1/7 23:19
 */
public class Solution_2 {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15},
        };

        int[][] arr1 = {
                {},
                {},
        };

        System.out.println(Find(7, arr1));
    }

    public static boolean Find(int target, int[][] array) {
        // 从右上角开始寻找
        int colStart = array[0].length - 1;
        int rowStart = 0;
        while (rowStart <= array.length - 1 && colStart >= 0) {
            //int start = array[rowStart][colStart];
            if (target < array[rowStart][colStart]) {
                colStart--;
            } else if (target > array[rowStart][colStart]) {
                rowStart++;
            } else {
                return true;
            }
        }
        return false;
    }
}
