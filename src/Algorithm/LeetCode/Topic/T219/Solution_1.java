package Algorithm.LeetCode.Topic.T219;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther gongfukang
 * @Date 6/15 19:37
 */
public class Solution_1 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> recordMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (recordMap.containsKey(nums[i])) {
                if (absolute(i - recordMap.get(nums[i])) <= k && absolute(i - recordMap.get(nums[i])) != 0)
                    return true;
            }
            recordMap.put(nums[i], i);
        }
        return false;
    }

    private static int absolute(int temp) {
        return temp > 0 ? temp : (-temp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
