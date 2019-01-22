package Algorithm.LeetCode.Topic.T46;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther gongfukang
 * @Date 6/19 10:04
 */
public class Solution {

    private static List<String> res = new LinkedList<String>();
    private static boolean[] used;

    public static List<String> permute(char[] nums) {

        used = new boolean[nums.length];
        if (nums.length == 0) {
            return res;
        }
        //存储在递归过程中生成的排列
        StringBuffer p = new StringBuffer();
        generatePermutation(nums, 0, p);
        return res;
    }

    /**
     * p中保存了一个有 index 个元素的排列
     * 向这个排列的末尾添加第 index + 1 个元素，获得一个有 index + 1 个元素的排列
     */
    public static void generatePermutation(char[] nums, int index, StringBuffer p) {

        // 找到一个全排列，递归终止条件
        if (index == nums.length) {
            res.add(p.toString());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // 将 nums[i] 添加到 p 中
                p.append(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                //删除
                p.deleteCharAt(p.length() - 1);
                used[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) {
        char[] nums = {'1', '2', '3', '4'};
        List<String> resultList = permute(nums);
        System.out.println(resultList);
    }
}
