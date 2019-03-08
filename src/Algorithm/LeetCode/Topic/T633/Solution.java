package Algorithm.LeetCode.Topic.T633;

/**
 * @auther G.Fukang
 * @date 3/8 23:03
 */
public class Solution {

    public boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.sqrt(c);
        for (int start = 0, end = sqrt; start <= sqrt && sqrt >= 0; ) {
            int sum = start * start + end * end;
            if (sum == c)
                return true;
            else if (sum < c)
                start++;
            else
                end--;
        }
        return false;
    }
}
