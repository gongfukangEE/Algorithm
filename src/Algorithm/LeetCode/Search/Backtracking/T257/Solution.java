package Algorithm.LeetCode.Search.Backtracking.T257;

import Algorithm.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/15 21:47
 */
public class Solution {

    private List<String> res = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        List<Integer> valusList = new ArrayList<>();
        doBinaryTreePaths(root, valusList);
        return res;
    }

    private void doBinaryTreePaths(TreeNode node, List<Integer> valList) {
        if (node == null) {
            return;
        }
        // 添加节点
        valList.add(node.val);
        if (node.left == null && node.right == null) {
            res.add(buildPath(valList));
        } else {
            doBinaryTreePaths(node.left, valList);
            doBinaryTreePaths(node.right, valList);
        }
        valList.remove(valList.size() - 1);
    }

    private String buildPath(List<Integer> valusList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < valusList.size(); i++) {
            stringBuilder.append(valusList.get(i));
            if (i != valusList.size() - 1) {
                stringBuilder.append("->");
            }
        }
        return stringBuilder.toString();
    }
}
