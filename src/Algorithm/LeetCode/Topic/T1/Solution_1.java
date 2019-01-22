package Algorithm.LeetCode.Topic.T1;

/**
 * @Auther gongfukang
 * @Date 6/15 16:34
 */
class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        boolean success = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)  {
                    res[0] = i;
                    res[1] = j;
                    success = true;
                } else
                    continue;
            }
            if (success) {
                break;
            }
        }
        return res;
    }
}
