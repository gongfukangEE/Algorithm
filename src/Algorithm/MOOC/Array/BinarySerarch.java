package Algorithm.MOOC.Array;

/**
 * @Auther gongfukang
 * @Date 6/13 22:44
 */
public class BinarySerarch {
    public static int binarySearch(int[] arr, int n, int target) {
        // 定义一个前闭后闭的区间
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            //如果取 l + r，则整型溢出
            int mid = l + (r - l) / 2;
            if (arr[mid] == target)
                return mid;

            if (target > arr[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
