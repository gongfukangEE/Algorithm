package Algorithm.LeetCode.Tree.T104;

import Algorithm.commons.TreeNode;

/**
 * @auther G.Fukang
 * @date 4/16 22:39
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
