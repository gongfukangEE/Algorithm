package Algorithm.LeetCode.T104;

import Algorithm.LeetCode.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 6/18 10:35
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        int leftMaxDepth, rightMaxDepth;
        if (root != null) {
            leftMaxDepth = maxDepth(root.left);
            rightMaxDepth = maxDepth(root.right);
        } else {
            return 0;
        }
        return leftMaxDepth > rightMaxDepth ? leftMaxDepth + 1 : rightMaxDepth + 1;
    }
}
