package Algorithm.Offer.T51;

/**
 * @Auther gongfukang
 * @Date 1/21 9:39
 */
public class Solution {
    /**
     * 不包含 A[i]
     * 从左向右累乘；从右向左累乘
     */
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= A[i], i++) {
            B[i] = product;
        }
        for (int i = n - 1, product = 1; i>= 0; product *= A[i], i--) {
            B[i] *= product;
        }
        return B;
    }
}
