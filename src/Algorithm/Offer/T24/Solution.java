package Algorithm.Offer.T24;

import Algorithm.commons.TreeNode;

import java.util.ArrayList;

/**
 * @Auther gongfukang
 * @Date 1/13 21:37
 */
public class Solution {

    /**
     * 递归：
     * 1. 进入一个节点：list.add && sum+=value
     * 2. 退出一个节点：list.remove && sum-=sum
     */
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    int sum = 0;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null || target == 0) {
            return ret;
        }
        paths(root, target);
        return ret;
    }

    private void paths(TreeNode node, int target) {
        if (node == null || sum > target) {
            return;
        }
        int value = node.val;
        list.add(value);
        sum += value;
        if (node.left == null && node.right == null) {
            if (sum == target) {
                ret.add(new ArrayList<Integer>(list));
            }
        } else {
            // 进入一个节点：1. list.add  2. sum+=value
            paths(node.left, target);
            paths(node.right, target);
        }
        // 退出一个节点：1. list.remove  2. sum-=sum
        list.remove((Object) value);
        sum -= value;
    }
}
