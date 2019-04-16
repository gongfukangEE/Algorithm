package Algorithm.LeetCode.Search.Backtracking.T46M;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/15 23:22
 */
public class Solution {

    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null){
            return res;
        }
        doPermute(new ArrayList<Integer>(), new boolean[nums.length], nums);
        return res;
    }

    private void doPermute(List<Integer> list, boolean[] marked, final int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) {
                continue;
            }
            // 标记访问
            marked[i] = true;
            // 添加元素
            list.add(nums[i]);
            // 递归
            doPermute(list, marked, nums);
            // 取消标记
            marked[i] = false;
            // 删除元素
            list.remove(list.size() - 1);
        }
    }
}
