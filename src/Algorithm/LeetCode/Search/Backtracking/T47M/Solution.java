package Algorithm.LeetCode.Search.Backtracking.T47M;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/16 15:25
 */
public class Solution {


    /**
     * 元素先排序
     * 1. 如果当元素 i 已经被标记过，直接跳过
     * 2. 如果当前元素 i 没有被标记过，但是元素 i 和元素 i - 1 相同，则直接跳过
     * @author G.Fukang
     * @date: 4/16 16:00
     */
    private List<List<Integer>> resList = new ArrayList<>();
    private boolean[] marked;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return resList;
        }
        this.marked = new boolean[nums.length];
        // 元素排序
        Arrays.sort(nums);
        doPermuteUnique(new ArrayList<Integer>(), nums);
        return resList;
    }

    private void doPermuteUnique(List<Integer> vaules, final int[] nums) {
        if (vaules.size() == nums.length) {
            resList.add(new ArrayList<>(vaules));
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i != 0 && marked[i - 1] && nums[i] == nums[i - 1]) || marked[i]) {
                continue;
            }
            // 标记元素
            marked[i] = true;
            // 添加元素
            vaules.add(nums[i]);
            // 递归
            doPermuteUnique(vaules, nums);
            // 取消标记
            marked[i] = false;
            // 删除元素
            vaules.remove(vaules.size() - 1);
        }
    }
}
