package Algorithm.LeetCode.TwoPonits.T88;

/**
 * @auther G.Fukang
 * @date 3/11 23:12
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        new Solution().merge(nums1, 3, nums2, 3);
        for (int item : nums1)
            System.out.print(item + " ");
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0) {
            int num1 = nums1[i];
            int num2 = nums2[j];
            if (num1 >= num2) {
                nums1[index] = num1;
                i--;
            } else {
                nums1[index] = num2;
                j--;
            }
            index--;
        }
        while (j >= 0)
            nums1[index--] = nums2[j--];
    }
}
