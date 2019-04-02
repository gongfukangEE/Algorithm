package Algorithm.LeetCode.Greedy.T121;

/**
 * @auther G.Fukang
 * @date 4/2 20:38
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length ==  0 || prices.length == 1) {
            return 0;
        }
        int sum = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            sum += (prices[i + 1] - prices[i]);
            sum = sum > 0 ? sum : 0;
            res = sum > res ? sum : res;
        }
        return res;
    }
}
