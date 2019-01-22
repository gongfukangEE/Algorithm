package Algorithm.Offer.Topic.T25;

import Algorithm.commons.RandomListNode;

/**
 * @Auther gongfukang
 * @Date 1/13 21:37
 */
public class Solution {

    /**
     * 1. 复制每个节点，并依次插入，比如：A->A1->B->B1...
     * 2. 将每个节点的 Random 引用复制到复制节点上
     * 3. 拆分成原链表和 copy 链表
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode temp = new RandomListNode(cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        cur = pHead;
        while (cur != null) {
            RandomListNode temp = cur.next;
            if (cur.random != null) {
                // 由于复制，指向随机节点的下一个节点
                temp.random = cur.random.next;
            }
            cur = temp.next;
        }
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }
}
