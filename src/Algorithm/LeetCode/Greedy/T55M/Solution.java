package Algorithm.LeetCode.Greedy.T55M;

/**
 * @auther G.Fukang
 * @date 5/8 20:47
 */
public class Solution {

    /**
     * nums[i] + i >= end
     * 表示从 nums[i] 可以跳到 end 位置
     */
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= end) {
                end = i;
            }
        }
        return end == 0;
    }

    /**
     * 贪心算法：从前向后跳，每次跳最远的距离，注意 start >= i(存在 0 的情况)
     */
    public boolean canJump_I (int[] nums) {
        int start = 0;
        for (int i = 0; i < nums.length && start >= i; i++) {
            start = Math.max(start, nums[i] + i);
        }
        return start >= nums.length - 1;
    }
}
