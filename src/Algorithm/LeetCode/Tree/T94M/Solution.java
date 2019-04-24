package Algorithm.LeetCode.Tree.T94M;

import Algorithm.commons.TreeNode;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @auther G.Fukang
 * @date 4/19 9:17
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            curNode = node.right;
        }

        return list;
    }
}
