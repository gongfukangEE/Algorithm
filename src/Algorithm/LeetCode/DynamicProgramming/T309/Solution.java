package Algorithm.LeetCode.DynamicProgramming.T309;

/**
 * @auther G.Fukang
 * @date 5/24 20:20
 */
public class Solution {

    /**
     * 动态规划
     * 需要两个转移方程
     * sell[i] 表示第 i 天时未持有股票的最大利润，也就是不买股票
     * buy[i] 表示第 i 天时持有股票的最大利润，也就是不卖股票
     *      sell[i] = Max{sell[i - 1], buy[i - 1] + prices[i]}
     *          1. sell[i - 1] 表示今天什么也没操作，利润和昨天一样
     *          2. buy[i - 1] + prices[i] 表示今天卖出了股票
     *      buy[i] = Max{buy[i - 1], sell[i - 2] - price[i]}
     *          1. buy[i - 1] 表示今天不卖股票，跟昨天一样
     *          2. 由于存在冷冻期，则今天要是买股票，肯定 i - 2 卖出了股票，今天又买入，要减去 price[i]
     * 最大利润就是今天不买股票的利润，也就是 sell[length - 1]
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int length = prices.length;
        // 初始化
        int[] sell = new int[length];
        int[] buy = new int[length];
        sell[0] = 0;
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], (i >= 2 ? sell[i - 2] : 0) - prices[i]);
        }
        return sell[length - 1];
    }
}
