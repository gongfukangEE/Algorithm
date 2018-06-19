package Algorithm.LeetCode.T77;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther gongfukang
 * @Date 6/19 21:02
 * 剪枝
 */
public class Solution {

    private static List<String> res = new LinkedList<String>();

    public static List<String> combine(int n, int k) {

        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        StringBuffer c =new StringBuffer();
        generateCombinations(n, k, 1, c);
        return res;
    }

    /**
     * 求解 C(n,k) 当前已经找到的组合存储在c中，需要从 start 开始搜索新的元素
     */
    private static void generateCombinations(int n, int k, int start, StringBuffer c){

        // 递归终止条件
        if(c.length() == k) {
            res.add(c.toString());
            return;
        }

        //剪枝（最后一个数没必要取）
        // 还有 k - c.size() 个空位，所以，[i...n] 中至少要有 k-c.size() 个元素
        // i 最多为 n - (k - c.size()) + 1
        for (int i = start; i <= n - (k - c.length()) + 1; i++) {
            c.append(i);
            generateCombinations(n, k, i + 1, c);
            c.deleteCharAt(c.length() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        int n, k;
        n = 4;
        k = 2;
        System.out.println(combine(n, k));
    }
}
