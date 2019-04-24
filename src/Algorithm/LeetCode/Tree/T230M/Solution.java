package Algorithm.LeetCode.Tree.T230M;

import Algorithm.commons.TreeNode;

import java.util.ArrayList;

/**
 * @auther G.Fukang
 * @date 4/21 22:15
 */
public class Solution {

    private ArrayList<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return list.get(k - 1);
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) return;
        inOrder(node.left, k);
        list.add(node.val);
        if (k-- == 0) {
            return;
        }
        inOrder(node.right, k);
    }
}
