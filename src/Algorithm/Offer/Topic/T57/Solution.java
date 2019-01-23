package Algorithm.Offer.Topic.T57;

import Algorithm.commons.TreeLinkNode;

/**
 * @Auther gongfukang
 * @Date 1/21 17:26
 */
public class Solution {

    /**
     * 分析中序遍历下一个节点出现的情况：
     * 1. 当前节点为叶节点
     *      1. 如果为 root 节点，返回 null
     *      2. 当前节点在左叶节点，出现在父节点
     *      3. 当前节点在右叶节点，向上遍历父节点的父节点，直到父节点为左节点
     * 2. 当前节点为根节点
     *      1. 右节点存在，沿着右节点的左节点一直找，直到叶节点
     *      2. 右节点不存在，向上遍历父节点，直到父节点为左节点
     *
     * @author G.Fukang
     * @date: 1/23 20:49
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.left == null && pNode.right == null) {
            if (pNode.next == null) {
                return null;
            }
            if (pNode == pNode.next.left) {
                return pNode.next;
            } else {
                while (pNode.next != null) {
                    if (pNode.next.left == pNode) {
                        return pNode.next;
                    } else {
                        pNode = pNode.next;
                    }
                }
                return null;
            }
        } else {
            if (pNode.right != null) {
                pNode = pNode.right;
                while (pNode.left != null && pNode.right != null) {
                    pNode = pNode.left;
                }
                return pNode;
            } else {
                if (pNode.next == null) {
                    return null;
                } else if (pNode.next.left == pNode) {
                    return pNode.next;
                } else {
                    pNode = pNode.next;
                    while (pNode.next != null) {
                        if (pNode.next.left == pNode) {
                            return pNode.next;
                        } else {
                            pNode = pNode.next;
                        }
                    }
                }
                return null;
            }
        }
    }

    /**
     * 1. 右子树不为空，找到右子树的最左节点
     * 2. 右子树为空，向上遍历父节点，直到父节点为左节点
     * @author G.Fukang
     * @date: 1/23 21:55
     */
    public TreeLinkNode GetNext_I(TreeLinkNode pNode) {
        if(pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = parent;
            }
        }
        return null;
    }
}
