package Algorithm.Offer.Topic.T39;

import Algorithm.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 1/19 23:28
 */
public class Solution {

    /**
     * 平衡二叉树：左右子树的节点高度差不超过 1
     * 1. 空树为平衡二叉树
     * 2. 左右子树高度差超过 1 为非平衡二叉树
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHigh = TreeDeep(root.left);
        int rightHigh = TreeDeep(root.right);
        if (Math.abs(leftHigh - rightHigh) > 1) {
            return false;
        }
        boolean left = IsBalanced_Solution(root.left);
        boolean right = IsBalanced_Solution(root.right);
        return left && right;
    }

    public int TreeDeep(TreeNode node) {
        return (node == null) ? 0 : (1 + Math.max(TreeDeep(node.left), TreeDeep(node.right)));
    }
}
