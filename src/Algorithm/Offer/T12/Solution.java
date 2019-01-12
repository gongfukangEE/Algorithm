package Algorithm.Offer.T12;

/**
 * @Auther gongfukang
 * @Date 1/12 15:12
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Power_II(2, -3));
    }

    /**
     * 暴力
     */
    public static double Power_I(double base, int exponent) {
        double result = 1;
        if (exponent == 0) {
            return 1;
        } else {
            for (int i = 1; i <= Math.abs(exponent); i++) {
                result = result * base;
            }
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    /**
     * 递归求解 O(logN)
     * 1. n 为偶数：a^n = (a*a)^(n/2)
     * 2. n 为奇数：a^n = (a*a)^((n-1)/2) * a
     */
    public static double Power_II(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double result = Power_II(base * base, exponent / 2);
        if (exponent % 2 == 1) {
            result = result * base;
        }
        return isNegative ? 1/result : result;
    }
}
