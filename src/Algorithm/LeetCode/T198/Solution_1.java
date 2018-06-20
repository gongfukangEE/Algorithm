package Algorithm.LeetCode.T198;

/**
 * @Auther gongfukang
 * @Date 6/20 20:25
 * 记忆化搜索
 */
public class Solution_1 {

    // memo[i] 表示考虑抢劫 nums[i,...,n] 所能获得的最大收益
    private static int[] memo;

    public static int rob(int[] nums) {
        memo = new int[nums.length];
        return tryRob(nums, 0);
    }

    /**
     * 考虑抢劫 nums[index,...,nums.length]这个范围的所有房子
     */
    private static int tryRob(int[] nums, int index) {
        if (index >= nums.length)
            return 0;
        if(memo[index] != 0)
            return memo[index];
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = max(res, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = res;
        return res;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
