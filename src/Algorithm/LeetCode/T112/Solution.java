package Algorithm.LeetCode.T112;

import Algorithm.LeetCode.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 6/18 20:18
 */
public class Solution {
    public boolean hasPathSum (TreeNode root, int sum) {
        //确实 root 为叶子节点
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return root.val == sum;
        if (hasPathSum(root.left, sum - root.val))
            return true;
        if (hasPathSum(root.right, sum - root.val))
            return true;
        return false;
    }
}
