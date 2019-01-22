package Algorithm.Offer.T38;

import Algorithm.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 1/19 16:57
 */
public class Solution {

    /**
     * 递归，节点层数为树的深度
     * Tips: 从叶子节点开始，每次加一层
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = TreeDepth(root.left);
            int right = TreeDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
