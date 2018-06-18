package Algorithm.LeetCode.T226;

import Algorithm.LeetCode.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 6/18 11:05
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
