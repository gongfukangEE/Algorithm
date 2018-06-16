package Algorithm.LeetCode.T1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther gongfukang
 * @Date 6/15 16:39
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {map.get(temp),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
