package Algorithm.Offer.T10;

/**
 * @Auther gongfukang
 * @Date 1/12 12:45
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(RectCover(5));
    }

    /**
     * 斐波那契数列
     * 1. 大矩阵为 2*0 -> 0 种方式
     * 2. 大矩阵为 2*1 -> 1 种方式
     * 3. 大矩阵为 2*2 -> 2 种方式
     * 4. 大矩阵为 2*n
     *     1. 第一块放 2*1，剩下有 Cover(n-1) 种方式
     *     2. 第一块放 1*2，由于第一个放 1*2，则对应 2*2 矩阵摆放那个确定，剩下有 Cover(n-2) 种
     */
    public static int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int pre1 = 1;
        int pre2 = 2;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
