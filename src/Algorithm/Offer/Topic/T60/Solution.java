package Algorithm.Offer.Topic.T60;

import Algorithm.commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther gongfukang
 * @Date 1/21 21:34
 */
public class Solution {

    /**
     * 借助 Queue，同二叉树的层序遍历
     * @author G.Fukang
     * @date: 1/23 22:53
     */
    Queue<TreeNode> queue = new LinkedList<>();
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0) {
                ret.add(list);
            }
        }
        return ret;
    }
}
