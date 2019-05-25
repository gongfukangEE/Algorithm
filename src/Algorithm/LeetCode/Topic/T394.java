package Algorithm.LeetCode.Topic;

import java.util.Stack;

/**
 * @auther G.Fukang
 * @date 5/25 20:20
 */
public class T394 {

    /**
     * 两个栈实现
     * stack1：保存 [] 中的元素出现的个数
     * stack2：保存 [] 中的元素
     */
    public String decodeString(String s) {

        String res = "";
        // 记录'['之前的数字
        Stack<Integer> countStack = new Stack<>();
        // 记录'['之前的运算结果
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        int curNum = 0;
        while (idx < s.length()) {
            char ch = s.charAt(idx);
            if (Character.isDigit(ch)) {
                while (Character.isDigit(s.charAt(idx)))
                    curNum = 10 * curNum
                            + (s.charAt(idx++) - '0');
            } else if (ch == '[') {
                resStack.push(res);
                res = "";
                countStack.push(curNum);
                curNum = 0;
                idx++;
                // 取出计算结果，和数字
            } else if (ch == ']') {
                StringBuilder temp =
                        new StringBuilder(resStack.pop());

                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
                // 字母
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
