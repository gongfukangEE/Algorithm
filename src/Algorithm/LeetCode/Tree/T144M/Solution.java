package Algorithm.LeetCode.Tree.T144M;

import Algorithm.commons.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @auther G.Fukang
 * @date 4/18 23:24
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            list.add(node.val);
            // 先右后左，在栈中 左先弹出，保证左子树先遍历
            stack.push(node.right);
            stack.push(node.left);
        }
        return list;
    }
}
