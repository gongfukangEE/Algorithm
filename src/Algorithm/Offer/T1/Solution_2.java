package Algorithm.Offer.T1;

/**
 * @Auther gongfukang
 * @Date 1/7 23:19
 * O(M + N) + O(1)
 */
public class Solution_2 {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9, 11},
                {2, 4, 9, 12, 18},
                {4, 7, 10, 13, 20},
                {6, 8, 11, 15, 22},
        };

        int[][] arr1 = {
                {},
                {},
        };

        System.out.println(Find(7, arr1));

        /*
            arr.length : 行
            arr[0].length : 列
        */
    }

    public static boolean Find(int target, int[][] array) {
        // 考虑边界问题
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        } else {
            // 从右上角开始寻找
            int colStart = array[0].length - 1;
            int rowStart = 0;
            while (rowStart <= array.length - 1 && colStart >= 0) {
                int start = array[rowStart][colStart];
                // 如果大于，则向下寻找；如果小于，则向左寻找
                if (target < start) {
                    colStart--;
                } else if (target > start) {
                    rowStart++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
