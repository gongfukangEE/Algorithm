package Algorithm.Offer.T23;

import Algorithm.commons.TreeNode;

/**
 * @Auther gongfukang
 * @Date 1/13 21:29
 */
public class Solution {

    /**
     * 后序遍历：左右根 --> 后序遍历序列最后一个值为 root，左子树均小于 root，右子树大于 root
     * 1. 确定 root
     * 2. 找到第一个大于 root 的索引，为右子树起点
     * 3. 遍历右子树，大于 root 返回 false
     * 4. 判断左右子树是不是后序遍历序列
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return Verify(sequence, 0, sequence.length - 1);
    }

    private boolean Verify(int[] sequence, int left, int right) {
        if (right - left <= 1) {
            return true;
        }
        int root = sequence[right];
        int index = left;
        while (index < right && sequence[index] <= root) {
            ++index;
        }
        for (int i = index; i < right; i++) {
            if (sequence[i] <= root) {
                return false;
            }
        }
        return Verify(sequence, left + 1, index - 1) && Verify(sequence, index, right - 1);
    }
}
