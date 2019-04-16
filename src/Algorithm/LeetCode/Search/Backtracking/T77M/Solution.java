package Algorithm.LeetCode.Search.Backtracking.T77M;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/16 16:03
 */
public class Solution {


    /**
     * 去重，从剩下的元素中选择
     *
     * @author G.Fukang
     * @date: 4/16 17:09
     */
    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        doCombine(new ArrayList<Integer>(), n, k, 1);
        return resList;
    }

    private void doCombine(List<Integer> valus, int n, int k, int start) {
        if (k == 0) {
            resList.add(new ArrayList<>(valus));
            return;
        }
        for (int i = start; i <= n - k; i++) {
            // 添加元素
            valus.add(i);
            // 递归
            doCombine(valus, n, k - 1, i + 1);
            // 删除元素
            valus.remove(valus.size() - 1);
        }
    }
}
