package Algorithm.LeetCode.DynamicProgramming.T213M;

/**
 * @auther G.Fukang
 * @date 4/23 21:54
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution().rob(nums));
    }


    /**
     * 两种情况：
     *      1. 抢劫 nums[0] 房子，则不能抢最后一个房子
     *      2. 抢劫 nums[1] 房子，可以抢最后一个房子
     * Max(1,2)
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(doRob(nums, 0, nums.length - 1), doRob(nums, 1, nums.length));
    }

    private int doRob(int[] nums, int first, int length) {
        int pre1 = 0;
        int pre2 = 0;
        for (int i = first; i < length; i++) {
            int res = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = res;
        }
        return pre1;
    }
}
