package Algorithm.Offer.Topic.T20;


import java.util.Stack;

/**
 * @Auther gongfukang
 * @Date 1/13 11:13
 */
public class Solution {


    /**
     * 主栈：顺序存储实际数据
     * 辅助栈：存储对于主栈内，当前大小数据量的最小值
     * 1. 主栈依次 push 数据
     * 2. 辅助栈为空，直接 push；辅助栈不为空，比较要 push 的数据与当前栈顶元素，puhs 小的那个
     * 3. 出栈：主栈和辅助栈均同时 pop
     * 4. min：辅助栈 peek
     */
    // 主栈
    private Stack<Integer> stack1 = new Stack<>();
    // 辅助栈
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        int newNode;
        if (stack2.isEmpty()) {
            newNode = node;
        } else {
            newNode = (node <= stack2.peek() ? node : stack2.peek());
        }
        stack2.push(newNode);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
