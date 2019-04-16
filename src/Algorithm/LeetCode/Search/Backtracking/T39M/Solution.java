package Algorithm.LeetCode.Search.Backtracking.T39M;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/16 17:21
 */
public class Solution {

    /**
     * 元素可以取任意多个，则在递归时，start 值不自增
     *
     * @author G.Fukang
     * @date: 4/16 17:48
     */
    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target == 0 || candidates.length == 0) {
            return resList;
        }
        doCombinationSum(candidates, new ArrayList<Integer>(), 0, target);
        return resList;
    }

    private void doCombinationSum(int[] candidates, List<Integer> valus, int start, int target) {
        if (target == 0) {
            resList.add(new ArrayList<>(valus));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                // 添加元素
                valus.add(candidates[i]);
                // 递归
                doCombinationSum(candidates, valus, i, target - candidates[i]);
                // 删除元素
                valus.remove(valus.size() - 1);
            }
        }
    }
}
