package Algorithm.LeetCode.Tree.T235;

import Algorithm.commons.TreeNode;

/**
 * @auther G.Fukang
 * @date 4/21 22:32
 */
public class Solution {

    /**
     * 二叉搜索树的公共祖先，大于等于左子树节点，小于等于右子树节点
     *
     * @author G.Fukang
     * @date: 4/21 22:43
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
