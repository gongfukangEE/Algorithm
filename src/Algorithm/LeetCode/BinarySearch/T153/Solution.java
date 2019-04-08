package Algorithm.LeetCode.BinarySearch.T153;

/**
 * @auther G.Fukang
 * @date 4/7 23:35
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
        System.out.println(new Solution().findMin(new int[]{3,4,5,1,2}));
    }

    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (nums[mid] > nums[h]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }
}
