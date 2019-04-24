package Algorithm.LeetCode.Tree.T145H;

import Algorithm.commons.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @auther G.Fukang
 * @date 4/18 23:35
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            list.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(list);

        return list;
    }
}
