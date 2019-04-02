package Algorithm.LeetCode.Greedy.T53;

/**
 * @auther G.Fukang
 * @date 4/2 20:32
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int sum = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = sum > res ? sum : res;
            sum = sum >= 0 ? sum : 0;
        }
        return res;
    }
}
