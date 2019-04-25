package Algorithm.LeetCode.Hash.T20;

import java.util.Stack;

/**
 * @auther G.Fukang
 * @date 4/24 23:06
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charS = s.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            if (charS[i] == '(' || charS[i] == '[' || charS[i] == '{') {
                stack.push(charS[i]);
            } else {
                if (stack.size() == 0)
                    return false;
                char c = stack.peek();
                stack.pop();
                char match;
                if (charS[i] == ')')
                    match = '(';
                else if (charS[i] == ']')
                    match = '[';
                else
                    match = '{';

                if (c != match)
                    return false;
            }
        }
        if (stack.size() != 0)
            return false;
        else
            return true;
    }
}
