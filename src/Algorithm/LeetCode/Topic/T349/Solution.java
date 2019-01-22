package Algorithm.LeetCode.Topic.T349;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther gongfukang
 * @Date 6/15 15:17
 */
class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set set = new HashSet();
        Set resSet = new HashSet();
        int[] res = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                resSet.add(nums2[j]);
            }
        }
        if (resSet == null) {
            return null;
        } else {
            Iterator<Integer> it = resSet.iterator();
            while (it.hasNext()) {
                res[index++] = it.next();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {};
        intersection(nums1, nums2);
    }
}