package Algorithm.Offer.T3;


import Algorithm.commons.ListNode;
import Algorithm.commons.ListNodeUtil;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @Auther gongfukang
 * @Date 1/9 22:45
 */
public class Solution {

    public static void main(String[] args) {
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode first = listNodeUtil.createListNode(array);
        System.out.println(printListFromTailToHeadStack(first));
    }

    // 递归
    public static ArrayList<Integer> printListFromTailToHeadRecursion(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode != null) {
            result.addAll(printListFromTailToHeadRecursion(listNode.next));
            result.add(listNode.val);
        }
        return result;
    }

    // 栈
    public static ArrayList<Integer> printListFromTailToHeadStack(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
            return result;
    }
}
