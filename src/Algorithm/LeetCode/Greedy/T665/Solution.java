package Algorithm.LeetCode.Greedy.T665;

/**
 * @auther G.Fukang
 * @date 4/2 19:59
 */
public class Solution {

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            count++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return count <= 1;
    }
}
