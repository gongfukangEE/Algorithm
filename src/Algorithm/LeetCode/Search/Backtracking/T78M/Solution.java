package Algorithm.LeetCode.Search.Backtracking.T78M;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/16 19:34
 */
public class Solution {

    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        resList.add(new ArrayList<Integer>());
        if (nums.length == 0) {
            return resList;
        }
        for (int i = nums.length; i > 0; i--) {
            doSubsets(new ArrayList<>(), nums, 0, i);
        }
        return resList;
    }

    private void doSubsets(List<Integer> values, int[] nums, int start, int count) {
        if (count == 0) {
            resList.add(new ArrayList<>(values));
            return;
        }
        for (int i = start; i < nums.length - count + 1; i++) {
            // 添加元素
            values.add(nums[i]);
            // 递归
            doSubsets(values, nums, i + 1, count - 1);
            // 删除元素
            values.remove(values.size() - 1);
        }
    }
}
