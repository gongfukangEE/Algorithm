package Algorithm.LeetCode.Sort.T347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/1 22:28
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        for (Integer item : new Solution().topKFrequent(nums, k)) {
            System.out.print(item + " ");
        }
    }

    /**
     * 桶排序
     *
     * buckets {idnex = 1: 3 1 4; index = 2: 2 -1}
     * @author G.Fukang
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer> resList = new ArrayList<>();
        if (nums.length == 0 || k == 0) {
            return resList;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int value : map.keySet()) {
            int frequent = map.get(value);
            if (buckets[frequent] == null) {
                buckets[frequent] = new ArrayList<>();
            }
            buckets[frequent].add(value);
        }
        for (int i = buckets.length - 1; i >= 0 && resList.size() < k; i--) {
            if (buckets[i] != null) {
                resList.addAll(buckets[i]);
            }
        }
        return resList;
    }
}
