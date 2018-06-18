package Algorithm.LeetCode.T100;

import Algorithm.LeetCode.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 6/18 11:25
 */
public class Solution {
    public boolean isSameTree (TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val))
            return false;
        boolean leftIsSame = isSameTree(p.left, q.left);
        boolean rightIsSame = isSameTree(p.right, q.right);
        if (leftIsSame && rightIsSame)
            return true;
        else
            return false;
    }
}
