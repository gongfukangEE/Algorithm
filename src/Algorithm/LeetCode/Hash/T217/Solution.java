package Algorithm.LeetCode.Hash.T217;

import java.util.HashSet;

/**
 * @auther G.Fukang
 * @date 4/24 23:08
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
