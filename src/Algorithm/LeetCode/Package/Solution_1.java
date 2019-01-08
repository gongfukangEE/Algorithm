package Algorithm.LeetCode.Package;

/**
 * @Auther gongfukang
 * @Date 6/21 9:58
 * 0-1 背包问题，自顶向下
 * F(n, C) 考虑将 n 个物品放入容量为 C 的背包
 * F(i, C) = F(i - 1, C) = v(i) + F(i - 1, c - w(i))
 */
public class Solution_1 {

    public static int knapsack01(int[] w, int[] v, int C) {
        int n = w.length;
        return bestValue(w, v, n-1, C);
    }

    // 用 [0,...,index] 的物品，填充体积为 c 的背包的最大价值
    private static int bestValue(int[] w, int[] v, int index, int c){
        if(index < 0 || c <= 0)
            return 0;
        int res = bestValue(w, v, index - 1, c);
        if(c >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        return res;
    }
}
