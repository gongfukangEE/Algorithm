package Algorithm.LeetCode.BinarySearch.T34M;

import java.util.Arrays;

/**
 * @auther G.Fukang
 * @date 5/5 19:00
 */
public class T34M {

    /**
     * 二分查找
     * 含有重复元素的有序数组查找，二分时 left = mid + 1，找到重复元素最左边的元素
     * 先找到 target 所在的位置
     * 再找到 target + 1 所在的位置，target +1 的前一个位置就是重复元素最右边的位置
     * 边界问题：
     *      target 没找到，均为 -1
     *      target 找到，但是 数组长度为 1，均为 0
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = binSearch(target, nums);
        if (left == nums.length || nums[left] != target) {
            res[0] = -1;
            res[1] = -1;
        } else {
            res[0] = left;
            if (left == 0 && nums.length == 1) {
                res[1] = 0;
            } else {
                int right = binSearch(target + 1, nums);
                res[1] = right - 1;
            }
        }
        return res;
    }

    private int binSearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
