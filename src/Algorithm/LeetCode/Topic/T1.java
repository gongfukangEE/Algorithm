package Algorithm.LeetCode.Topic;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther G.Fukang
 * @date 5/1 20:14
 */
public class T1 {

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
