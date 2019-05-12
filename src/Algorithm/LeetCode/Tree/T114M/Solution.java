package Algorithm.LeetCode.Tree.T114M;

import Algorithm.commons.TreeNode;

/**
 * @auther G.Fukang
 * @date 5/12 20:57
 */
public class Solution {

    /**
     * 从根节点出发，先判断左子节点是否存在，若存在，则断开右子节点，将左子节点连接到右子节点位置
     * 然后将右子节点连接到左子树最右边的节点
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            // 判断左子节点
            if (cur.left != null) {
                TreeNode temp = cur.left;
                // 找到左子树的最右节点
                while (temp.right != null) {
                    temp = temp.right;
                }
                // 右子树接到左子树最右节点
                temp.right = cur.right;
                // 左子树接到右子树的位置
                cur.right = cur.left;
                // 左子树置为空
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
