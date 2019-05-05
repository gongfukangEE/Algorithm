package Algorithm.LeetCode.Topic;

import java.util.Arrays;

/**
 * @auther G.Fukang
 * @date 5/5 19:23
 */
public class T33M {


    /**
     * 二分查找
     * mid > left 左边是递增，如果 target 在左边，则左边二分查找
     * mid < right 右边是递增的，如果 target 在右边，则右边二分查找
     */
    public int search(int[] nums, int target) {
       if (nums == null || nums.length == 0) {
           return -1;
       }
       int left = 0;
       int right = nums.length - 1;
       while (left <= right) {
           int mid = (left + right) / 2;
           if (target == nums[mid]) {
               return mid;
           }
           // 右边是有序的
           if (nums[mid] < nums[right]) {
               // 二分查找
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
           } else {
               // 右边是无序的
               // target 位于 左边
               if (target >= nums[left] && target < nums[mid]) {
                   right = mid - 1;
               } else {
                   left = mid + 1;
               }
           }
       }
        return -1;
    }
}
