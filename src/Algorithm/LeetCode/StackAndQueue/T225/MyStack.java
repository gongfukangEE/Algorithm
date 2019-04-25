package Algorithm.LeetCode.StackAndQueue.T225;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther G.Fukang
 * @date 4/24 22:30
 */
public class MyStack {

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<>();
    }

    /**
     * 将一个元素 x 插入队列后，为了维护先入后出的顺序，需要将除 x 之外的元素依次出队，然后从队尾入队
     */
    public void push(int x) {
        queue.add(x);
        int count = queue.size();
        while (count-- > 1) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
