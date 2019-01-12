package Algorithm.Offer.T7;

/**
 * @Auther gongfukang
 * @Date 1/11 23:45
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
    }

    /**
     * 划分成子问题，然后将子问题缓存起来
     * 空间复杂度 O(1)
     */
    public static int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int pre1 = 1;
        int pre2 = 1;
        int result = 1;
        for(int i = 3; i <= n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
