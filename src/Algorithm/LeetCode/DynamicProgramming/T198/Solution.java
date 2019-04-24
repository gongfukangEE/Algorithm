package Algorithm.LeetCode.DynamicProgramming.T198;

/**
 * @auther G.Fukang
 * @date 4/23 21:18
 */
public class Solution {


    /**
     * dp[i] = Max{dp[i - 2] + nums[i], dp[i - 1]}
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int pre1 = 0;
        int pre2 = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }
}
