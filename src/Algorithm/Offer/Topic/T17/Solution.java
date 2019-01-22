package Algorithm.Offer.Topic.T17;

import Algorithm.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 1/12 22:56
 */
public class Solution {

    /**
     * 1. 先找到 root2 与 root1 数值相等的节点
     * 2. 比较左右子树是否相同
     * Tpis：
     *      1. 找到 root 值相同节点，匹配递归
     *      2. 找不到相同值节点，则分别在左右子树寻找，直到找到再匹配递归
     */
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean Flag = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                Flag = doHasSubtree(root1, root2);
            }
            if (!Flag) {
                Flag = HasSubtree(root1.left, root2);
            }
            if (!Flag) {
                Flag = HasSubtree(root1.right, root2);
            }
        }
        return Flag;
    }

    /**
     * 1. 先判断 root2 为空，此时不论 root1 为不为空，均为匹配
     * 2. 若 root1 为空，root2 不为空，则不匹配
     * 3. 左右子树递归
     * 4. 左右子树均匹配才为匹配
     */
    public static boolean doHasSubtree(TreeNode node1, TreeNode node2) {

        if (node2 == null) {
            return true;
        }

        if (node1 == null && node2 != null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return doHasSubtree(node1.left, node2.left) && doHasSubtree(node1.right, node2.right);
    }
}
