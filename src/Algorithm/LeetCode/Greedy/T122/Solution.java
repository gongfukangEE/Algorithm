package Algorithm.LeetCode.Greedy.T122;

/**
 * @auther G.Fukang
 * @date 4/2 20:21
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int value = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            value += prices[i] - prices[i + 1] <= 0 ? (prices[i] - prices[i + 1]) : 0;
        }
        return -value;
    }
}
