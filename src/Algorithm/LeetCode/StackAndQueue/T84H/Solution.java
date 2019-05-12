package Algorithm.LeetCode.StackAndQueue.T84H;


import java.util.Stack;

/**
 * @auther G.Fukang
 * @date 5/10 20:21
 */
public class Solution {

    /**
     * 单调栈实现
     * 直方图的面积最大：连续的矩阵尽可能多，最低一块的高度要尽可能高
     * 假设现在遍历到 i，如果栈顶元素小于 heights[i] ,表明这个 i 就是栈顶元素的左边界，
     * 而栈顶元素的右边界就是栈顶元素的下边一个元素（为空补-1）,这样就可以求得必须包含栈顶元素的最大矩形面积。
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            // 当前高度小于栈顶元素高度
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int cur = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, (i - left - 1) * heights[cur]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            res = Math.max(res, (heights.length - left - 1) * heights[cur]);
        }
        return res;
    }
}
