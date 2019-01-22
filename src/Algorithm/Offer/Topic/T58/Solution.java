package Algorithm.Offer.Topic.T58;

import Algorithm.commons.TreeNode;


/**
 * @Auther gongfukang
 * @Date 1/21 20:27
 */
public class Solution {

    /**
     * 递归
     * 1. proot 左右子树 left & right
     * 2. 左子树的右节点值 == 右子树的左节点值
     * 3. 这个节点相等，不断递归
     */
    boolean isSymmetrical(TreeNode pRoot) {

        if (pRoot == null || ( pRoot.left == null && pRoot.right == null)) {
            return true;
        }
        return IsCom(pRoot.left, pRoot.right);
    }

    private boolean IsCom(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null && node1.val == node2.val) {
            boolean left = IsCom(node1.left, node2.right);
            boolean right = IsCom(node1.right, node2.left);
            return left && right;
        }

        return false;
    }
}
