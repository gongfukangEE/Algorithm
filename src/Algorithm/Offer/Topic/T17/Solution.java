package Algorithm.Offer.Topic.T17;

import Algorithm.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 1/12 22:56
 */
public class Solution {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        if ((root1 != null && root2 == null) || (root1 == null)) return false;
        if (root1.val == root2.val) res = isSubtree(root1, root2);
        if (res) return true;
        else return isSubtree(root1.left, root2) | isSubtree(root1.right, root2);
    }

    private boolean isSubtree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if ((t1 == null) || (t1.val != t2.val)) return false;
        return isSubtree(t1.left, t2.left) & isSubtree(t1.right, t2.right);
    }
}
