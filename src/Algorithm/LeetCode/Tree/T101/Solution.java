package Algorithm.LeetCode.Tree.T101;

import Algorithm.commons.TreeNode;

/**
 * @auther G.Fukang
 * @date 4/17 23:09
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return doIsSymmetric(root.left, root.right);
    }

    private boolean doIsSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val) {
            return doIsSymmetric(left.left, right.right) && doIsSymmetric(left.right, right.left);
        } else {
            return false;
        }
    }
}
