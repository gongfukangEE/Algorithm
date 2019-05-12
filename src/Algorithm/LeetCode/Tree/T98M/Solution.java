package Algorithm.LeetCode.Tree.T98M;

import Algorithm.commons.TreeNode;

/**
 * @auther G.Fukang
 * @date 5/11 20:13
 */
public class Solution {


    /**
     * 递归
     * left<root<right
     * leftValue 和 rightValue 并不单表示为左节点和右节点，而是左边界和右边界
     * 在递归左子树时，更新 rightValue 为 当前节点值
     * 在递归右子树时，更新 leftValue 为 当前节点值
     * 注意：使用 long 型，因为节点值可能为 Integer.MAX_VALUE
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return doIsValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean doIsValidBST(TreeNode node, long leftValue, long rightValue) {
        if (node == null) {
            return true;
        }
        if (node.val <= leftValue || node.val >= rightValue) {
            return false;
        }
        return doIsValidBST(node.left, leftValue, node.val) && doIsValidBST(node.right, node.val, rightValue);
    }
}
