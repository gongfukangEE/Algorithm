package Algorithm.LeetCode.Topic.T454;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther gongfukang
 * @Date 6/15 17:12
 */
public class Solution {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (map.containsKey(C[i] + D[j])) {
                    int value = map.get(C[i] + D[j]);
                    map.put(C[i] + D[j], ++value);
                } else {
                    map.put(C[i] + D[j], 1);
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int temp = 0 - (A[i] + B[j]);
                if (map.containsKey(temp)) {
                    count += map.get(temp);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};

        System.out.println(fourSumCount(A,B,C,D));
    }
}
