package Algorithm.LeetCode.Tree.T110;

import Algorithm.commons.TreeNode;

/**
 * @auther G.Fukang
 * @date 4/16 23:04
 */
public class Solution {

    private boolean resFlag = true;
    public boolean isBalanced(TreeNode root) {
        maxDeep(root);
        return resFlag;
    }

    private int maxDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDeep(node.left);
        int right = maxDeep(node.right);
        if (Math.abs(left - right) > 1) {
            resFlag = false;
        }
        return Math.max(left, right) + 1;
    }
}
