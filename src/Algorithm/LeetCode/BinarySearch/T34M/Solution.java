package Algorithm.LeetCode.BinarySearch.T34M;

import java.util.Arrays;

/**
 * @auther G.Fukang
 * @date 4/8 10:10
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 7;
        System.out.println(Arrays.toString(new Solution().searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target);
        int right = binarySearch(nums, target + 1) - 1;
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{left, Math.max(left, right)};
        }
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int mid = (l + h) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l ;
    }
}
