package Algorithm.Offer.Topic.T18;

import Algorithm.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 1/13 10:06
 */
public class Solution {

    /**
     * 递归
     * 1. 交换左右子树
     * 2. 左右子树分别递归
     */
    public void Mirror(TreeNode root) {
        if (root != null) {
            swap(root);
            Mirror(root.left);
            Mirror(root.right);
        } else {
            return;
        }
    }

    public static void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
