package Algorithm.Offer.Topic.T31;

/**
 * @Auther gongfukang
 * @Date 1/18 20:22
 */
public class Solution {
    /**
     * 暴力解法
     *
     * @author G.Fukang
     * @date: 2/26 20:50
     */
    public int NumberOf1Between1AndN_Solution_I(int n) {
        int count = 0;
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < n + 1; i++)
            s.append(i);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
        }
        return count;
    }

    /**
     * 归纳法
     *
     * @author G.Fukang
     * @date: 2/26 21:08
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int i = 1;
        int high = 0;
        int current = 0;
        int low = 0;
        while ((n / i) != 0) {
            high = (n / i) % 10;
            low = n / (i * 10);
            current = n - (n / i) * i;
            if (high == 0)
                count += low * i;
            else if (high == 1)
                count += low * i + current + 1;
            else
                count += (low + 1) * i;
            i *= 10;
        }
        return count;
    }
}
