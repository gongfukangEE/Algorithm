package Algorithm.Offer.Topic.T61;

import Algorithm.commons.ListNode;
import Algorithm.commons.ListNodeUtil;
import Algorithm.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 1/21 21:35
 */
public class Solution {

    private StringBuffer stringbuffer = new StringBuffer();
    private int index = -1;

    public String Serialize(TreeNode root) {
        preOrder(root);
        return stringbuffer.toString();
    }

    private void preOrder(TreeNode node) {
        if (node == null)
            stringbuffer.append("#").append("!");
        else {
            stringbuffer.append(node.val).append("!");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public TreeNode Deserialize(String str) {
        index++;
        String[] DeserializeStr = str.split("!");
        TreeNode node = null;
        if (!DeserializeStr[index].equals("#")) {
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
