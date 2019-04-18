package Algorithm.LeetCode.Tree.T226;

import Algorithm.commons.TreeNode;

/**
 * @auther G.Fukang
 * @date 4/17 22:16
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swap(TreeNode node) {
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
    }
}
