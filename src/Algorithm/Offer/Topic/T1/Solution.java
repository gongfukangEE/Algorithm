package Algorithm.Offer.Topic.T1;

/**
 * @Auther gongfukang
 * @Date 1/7 22:41
 * 二分查找
 */
public class Solution {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        System.out.println(Find(17, arr));
    }

    public static boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > array[i][mid]) {
                    low = mid + 1;
                } else if (target < array[i][mid]) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
