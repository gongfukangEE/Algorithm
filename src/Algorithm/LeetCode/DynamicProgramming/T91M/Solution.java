package Algorithm.LeetCode.DynamicProgramming.T91M;

/**
 * @auther G.Fukang
 * @date 4/24 10:43
 */
public class Solution {

    public static void main(String[] args) {
        String s = "226";
        System.out.println(new Solution().numDecodings(s));
    }


    /**
     *          f(n - 1), 十位为 0， 不满足 <= 26
     * f(n) =
     *          f(n - 1) + f(n - 2)
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
