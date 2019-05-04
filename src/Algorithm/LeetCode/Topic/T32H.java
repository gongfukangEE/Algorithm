package Algorithm.LeetCode.Topic;


import java.util.Stack;

/**
 * @auther G.Fukang
 * @date 5/4 19:39
 */
public class T32H {

    public static void main(String[] args) {
        String s = ")()())()()(";
        System.out.println(new T32H().longestValidParentheses(s));
    }

    /**
     * start 记录有效括号的起始位置
     * 遍历 s，遇到 ( 将下标压入栈
     *         遇到 (
     *              如果栈为空，表示括号不匹配，将 start 更新为 i + 1，表示从下一个重新计数
     *              如果栈不为空，匹配括号
     *                  不断匹配，如果匹配到栈为空，则 max = Max(i - start, max)
     *                            如果栈不为空，则 max = Max(i - stack.peek(), max)
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        if (s.length() == 0) {
            return max;
        }
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    // 当前栈内括号不匹配，重新开始找有效括号起始位置
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i - start + 1);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
