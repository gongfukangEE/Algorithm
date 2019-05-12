package Algorithm.LeetCode.Tree.T105M;

import Algorithm.commons.TreeNode;

import java.util.HashMap;

/**
 * @auther G.Fukang
 * @date 5/12 20:28
 */
public class Solution {

    /**
     * 先序遍历的第一个位置是 root 节点，中序遍历的 root 节点位置在中间 p，在 root 节点左边的肯定是 root 的左子树的中序数组
     * 在 root 节点右边的肯定是 root 的右子树的中序数组，先序遍历到第二个位置到 p，就是 root 左子树的先序数组，p 右边就是 root 右子树的先序数组
     */
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            // 存储中序遍历的节点和索引值
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0);
    }

    private TreeNode buildTree(int[] preOrder, int preL, int preR, int inL) {
        if (preR < preL) {
            return null;
        }
        // 找到先序遍历的 root 节点，左边界值
        TreeNode root = new TreeNode(preOrder[preL]);
        // 获取 root 节点在中序遍历的位置
        int index = map.get(root.val);
        // 计算子树大小
        int leftSize = index - inL;
        // 重建左子树
        root.left = buildTree(preOrder, preL + 1, preL + leftSize, inL);
        // 重建右子树
        root.right = buildTree(preOrder, preL + leftSize + 1, preR, inL + leftSize + 1);

        return root;
    }
}
