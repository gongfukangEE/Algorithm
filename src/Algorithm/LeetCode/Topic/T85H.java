package Algorithm.LeetCode.Topic;

import java.util.Stack;

/**
 * @auther G.Fukang
 * @date 5/10 20:43
 */
public class T85H {

    /**
     * 相对于 T84，二维矩阵的每一层都可以看作一个直方图，输入矩阵有多少行，就可以形成多少个直方图
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        int[] h = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                h[j] = matrix[i][j] == '0' ? 0 : h[j] + 1;
            }
            res = Math.max(res, largestRectangleArea(h));
        }
        return res;
    }

    private int largestRectangleArea(int[] heights) {
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
