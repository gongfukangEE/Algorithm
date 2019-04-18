package Algorithm.LeetCode.Tree.T112;

import Algorithm.commons.TreeNode;

/**
 * @auther G.Fukang
 * @date 4/17 22:41
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
