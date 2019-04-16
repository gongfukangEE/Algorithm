package Algorithm.LeetCode.Search.Backtracking.T216;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/16 19:21
 */
public class Solution {

    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 1 || n < 1) {
            return resList;
        }
        doCombinationSum3(new ArrayList<Integer>(), k, n, 1, 9);
        return resList;
    }

    private void doCombinationSum3(List<Integer> values, int k, int sum, int start, int nums) {
        if (k < 0 || sum < 0) {
            return;
        }
        if (k == 0 && sum == 0) {
            resList.add(new ArrayList<>(values));
            return;
        }
        for (int i = start; i <= nums - k + 1; i++) {
            // 添加元素
            values.add(i);
            // 递归
            doCombinationSum3(values, k - 1, sum - i, i + 1, nums);
            // 删除元素
            values.remove(values.size() - 1);
        }
    }
}
