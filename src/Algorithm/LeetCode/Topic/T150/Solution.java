package Algorithm.LeetCode.Topic.T150;


import java.util.Stack;

/**
 * @Auther gongfukang
 * @Date 6/17 11:04
 */
public class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/") ) {
                String right = stack.peek();
                stack.pop();
                String left = stack.peek();
                stack.pop();
                stack.push(cal(left, right, tokens[i]).toString());
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.peek());
    }

    public static Integer cal(String a, String b, String character) {
        if (character.equals("+") )
            return Integer.parseInt(a) + Integer.parseInt(b);
        else if (character.equals("-") )
            return Integer.parseInt(a) - Integer.parseInt(b);
        else if (character.equals("*") )
            return Integer.parseInt(a) * Integer.parseInt(b);
        else
            return Integer.parseInt(a) / Integer.parseInt(b);
    }

    public static void main(String[] args) {
        String[] s = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(s));
    }
}
