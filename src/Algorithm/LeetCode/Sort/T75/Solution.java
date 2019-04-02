package Algorithm.LeetCode.Sort.T75;


/**
 * @auther G.Fukang
 * @date 4/2 10:07
 */
public class Solution {

    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }
    }

    /**
     *
     * 三路快排
     * @author G.Fukang
     * @date: 4/2 10:35
     */
    public void sortColors_II(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two){
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
               ++one;
            }
        }
    }

    private void swap(int[] arr, int i ,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
