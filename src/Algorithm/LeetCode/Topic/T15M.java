package Algorithm.LeetCode.Topic;

import Algorithm.commons.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 5/3 19:38
 */
public class T15M {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)    break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1])    continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    // 满足条件
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    // 去重处理
                    while(j < k && nums[j] == nums[j + 1]){
                        j++;
                    }
                    while(j < k && nums[k] == nums[k - 1]){
                        k--;
                    }

                    j++;
                    k--;
                }
            }
        }

        return res;
    }
}
