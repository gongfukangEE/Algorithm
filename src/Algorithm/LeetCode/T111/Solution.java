package Algorithm.LeetCode.T111;

import Algorithm.LeetCode.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 6/18 11:46
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if(root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        return minDepth(root.left) < minDepth(root.right) ? (minDepth(root.left) + 1) : (minDepth(root.right) + 1);
    }
}
