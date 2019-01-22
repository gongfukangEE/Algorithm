package Algorithm.Offer.Topic.T42;

import java.util.ArrayList;

/**
 * @Auther gongfukang
 * @Date 1/20 15:22
 */
public class Solution {

    /**
     * 二分查找
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean IsWithSum = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > sum - array[i]) {
                break;
            }
            IsWithSum = binSearch(array, sum - array[i]);
            if (IsWithSum) {
                list.add(array[i]);
                list.add(sum - array[i]);
                break;
            } else {
                continue;
            }
        }
        return list;
    }

    private boolean binSearch(int[] array, int k) {
        int l = 0;
        int r = array.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (k > array[m]) {
                l = m + 1;
            } else if (k < array[m]) {
                r = m;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针
     * 1. 一个指针从左边开始，一个指针从右边开始
     * 2. target < sum 左++  target > sum 右--
     */
    public ArrayList<Integer> FindNumbersWithSum_I(int[] array, int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        int start = 0;
        int end = array.length - 1;
        int target = 0;
        while (start < end) {
            target = array[start] + array[end];
            if (target < sum) {
                start++;
            } else if (target > sum) {
                end--;
            } else {
                ret.add(array[start]);
                ret.add(array[end]);
                return ret;
            }
        }
        return ret;
    }
}
