package Algorithm.LeetCode.Topic.T75;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther gongfukang
 * @Date 6/14 16:18
 */
class Solution {
    public void sortColors(int[] nums) {
        Map<String, Integer> map = new HashMap();
        map.put("0", 0);
        map.put("1", 0);
        map.put("2",0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int count = map.get("0") + 1;
                map.put("0",count);
            }
            if (nums[i] == 1) {
                int count = map.get("1") + 1;
                map.put("1",count);
            }
            if (nums[i] == 2) {
                int count = map.get("2") + 1;
                map.put("2",count);
            }
        }
        for (int j = 0; j< nums.length; j++) {
            if (j < map.get("0"))
                nums[j] = 0;
            else if (j < map.get("0") + map.get("1"))
                nums[j] = 1;
            else
                nums[j] = 2;
        }
    }
}
