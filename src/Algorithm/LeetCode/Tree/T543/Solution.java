package Algorithm.LeetCode.Tree.T543;

import Algorithm.commons.TreeNode;

/**
 * @auther G.Fukang
 * @date 4/16 23:19
 */
public class Solution {

    /**
     * 所以子树中任意两个节点的最大距离，不是根节点左右子树的最大距离
     *
     * @author G.Fukang
     * @date: 4/16 23:41
     */
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDeep(root);
        return max;
    }

   private int maxDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDeep(node.left);
        int right = maxDeep(node.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
   }
}
