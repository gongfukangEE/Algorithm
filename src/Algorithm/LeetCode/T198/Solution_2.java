package Algorithm.LeetCode.T198;

/**
 * @Auther gongfukang
 * @Date 6/20 22:28
 * 动态规划
 */
public class Solution_2 {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        // memo[i] 表示考虑抢劫 nums[ 1,...,n-1] 所能获得的最大收益
        int[] memo = new int[n];
        // memo[n - 1] 表示考虑抢劫 nums[n-1, n-1] 所能获得的最大收益，由于仅包含一座房子，则必定偷取
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // 每次都在求解 memo[i]
            for (int j = i; j < n; j++) {
                // 考虑偷取 nums[j] 房子
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }
}
