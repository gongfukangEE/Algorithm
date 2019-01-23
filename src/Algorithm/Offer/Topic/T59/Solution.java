package Algorithm.Offer.Topic.T59;

import Algorithm.commons.Tree;
import Algorithm.commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @auther G.Fukang
 * @date 1/23 22:29
 */
public class Solution {

    /**
     * 方法 1：queue + stack 奇数直接加 list，偶数行入 stack，再加 list
     * 方法 2：queue 行打印 + 偶数 Collections.reverse(list)
     * @author G.Fukang
     * @date: 1/23 23:17
     */
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    int row = 1;
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (row % 2 == 1) {
                    list.add(node.val);
                } else {
                    stack.add(node.val);
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            if (row % 2 == 0) {
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }
            }
            if (list.size() != 0) {
                ret.add(list);
            }
            row++;
        }
        return ret;
    }
}
