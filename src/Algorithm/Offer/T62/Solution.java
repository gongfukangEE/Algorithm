package Algorithm.Offer.T62;

import Algorithm.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 1/21 21:36
 */
public class Solution {

    /**
     * 二叉树中序遍历
     */
    private TreeNode retNode;
    int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return retNode;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }
        inOrder(node.left, k);
        count++;
        if (count == k) {
            retNode = node;
        }
        inOrder(node.right, k);
    }
}
