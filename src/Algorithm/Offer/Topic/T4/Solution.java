package Algorithm.Offer.Topic.T4;

import Algorithm.commons.TreeNode;

import java.util.HashMap;

/**
 * @Auther gongfukang
 * @Date 1/11 17:32
 */
public class Solution {

    /**
     * 递归
     * 1. 先序遍历的第一个位置是 root 节点
     * 2. 中序遍历的 root 节点位置在中间 p，在 root 左边的肯定是 root 的左子树的中序数组，右边是 root 的右子树的中序数组
     * 3. 先序遍历的第二个位置到 p，就是 root 左子树的先序数组，p 右边是 root 右子树的先序数组
     */
    // 存储中序遍历数组每个值对应的索引
    private HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        for (int i = 0; i < pre.length; i++) {
            map.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        // 先序遍历的 root 节点
        TreeNode root = new TreeNode(pre[preL]);
        // 找到 root 在中序遍历数组的位置
        int inIndex = map.get(root.val);
        // 中序遍历中左子树的范围
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}
