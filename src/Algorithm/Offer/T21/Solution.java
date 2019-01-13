package Algorithm.Offer.T21;


import java.util.Stack;

/**
 * @Auther gongfukang
 * @Date 1/13 15:57
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 3, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.IsPopOrder(arr1, arr2));
    }

    private Stack<Integer> stack = new Stack<>();

    /**
     * 辅助栈实现
     * 1. pushA 按顺序压栈
     * 2. 如果栈顶元素 == popA 元素，则出栈，直到不相等
     * 3. stack 栈为空，pushA 全部匹配完，则为 true，否则为 false
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int start = 0;
        for (int item : pushA) {
            stack.push(item);
            while (!stack.isEmpty() && stack.peek() == popA[start]) {
                stack.pop();
                ++start;
            }
        }
        if (start == (pushA.length) && stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
