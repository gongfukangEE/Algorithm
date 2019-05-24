package Algorithm.LeetCode.DynamicProgramming.T123H;

/**
 * @auther G.Fukang
 * @date 5/24 22:12
 */
public class Solution {

    /**
     * buy 表示不卖出股票的收益{不处理、买入股票}
     * sell 表示不买入股票的收益{不处理，卖出股票}
     * buy01 = Max{buy01, -prices[i]}
     * sell01 = Max{buy01 + price[i], sell01}
     * buy02 = Max{buy02, sell01-price[i]}
     * sell02 = Max{buy02 + price[i], sell02}
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int buyFist = -prices[0];
        int sellFist = 0;
        int buySecond = -prices[0];
        int sellSecond = 0;
        for (int i = 1; i < prices.length; i++) {
            // 第一次买入
            buyFist = Math.max(buyFist, -prices[i]);
            // 第一次卖出
            sellFist = Math.max(sellFist, buyFist + prices[i]);
            buySecond = Math.max(buySecond, sellFist - prices[i]);
            sellSecond = Math.max(sellSecond, buySecond + prices[i]);
        }
        return sellSecond;
    }
}
