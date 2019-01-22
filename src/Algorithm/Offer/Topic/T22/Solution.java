package Algorithm.Offer.Topic.T22;

import Algorithm.commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther gongfukang
 * @Date 1/13 17:04
 */
public class Solution {

    /**
     * 迭代：辅助队列
     * 1. 边界检测：空与非空
     * 2. root 节点入队
     * 3. 队列不为空，出队，出队节点的左右子树入队
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                res.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
