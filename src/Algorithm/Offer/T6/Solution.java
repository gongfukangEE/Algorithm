package Algorithm.Offer.T6;

/**
 * @Auther gongfukang
 * @Date 1/11 22:41
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        System.out.println(minNumberInRotateArray(arr));
    }

    /**
     * 二分查找
     * 1. min < right : 最小值位于右边 left=mid+1
     * 2. min > right : 最小值位于左边 right=mid [Tips: 当只剩下两个数字时，[6,2], left=6，right=2, mid=6, 则不能使用 right=mid-1 ]
     * 3. min = right : [1,0,1,1,1] 或者[1,1,1,0,1] 挨个试
     */
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else {
                left = left + 1;
            }
        }
        return array[left];
    }
}
