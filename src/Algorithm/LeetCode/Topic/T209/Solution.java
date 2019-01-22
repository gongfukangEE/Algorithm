package Algorithm.LeetCode.Topic.T209;

/**
 * @Auther gongfukang
 * @Date 6/15 10:56
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // 前闭后闭区间
        int l = 0;
        int r = -1;
        int sum = 0;
        int res = nums.length + 1;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                res = res > (r - l + 1) ? (r - l + 1) : res;
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {1,2,3,4,5};
        Solution test = new Solution();
        System.out.println(test.minSubArrayLen(s, nums));
    }
}
