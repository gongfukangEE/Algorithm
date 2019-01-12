package Algorithm.Offer.T11;

/**
 * @Auther gongfukang
 * @Date 1/12 13:04
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(NumberOf1_I(-5));
    }

    /**
     * 位运算
     * 1. 1 的二进制为 0000 ... 0000 0001，共计 32 位，每次向左移动一位，为 0000 0010
     * 2. 移位后与 n 做 & 操作，逐个检测 n 的每一位是否是 1
     */
    public static int NumberOf1_I(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((flag & n) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * n        : 10110100
     * n-1      : 10110011
     * n&(n-1)  : 10110000
     * n&(n-1):每 & 一次，去掉一个低位的 1
     */
    public static int NumberOf1_II(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n-1);
        }
        return count;
    }

}
