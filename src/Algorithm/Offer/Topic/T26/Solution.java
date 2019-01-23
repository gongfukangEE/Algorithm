package Algorithm.Offer.Topic.T26;

import Algorithm.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 1/15 22:35
 */
public class Solution {

    /**
     * 二叉树的中序遍历
     */
    private TreeNode pre = null;
    private TreeNode head = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;
        if (head == null) {
            head = node;
        }
        inOrder(node.right);
    }
}
