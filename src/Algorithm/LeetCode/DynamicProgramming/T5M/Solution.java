package Algorithm.LeetCode.DynamicProgramming.T5M;

/**
 * @auther G.Fukang
 * @date 5/2 19:01
 */
public class Solution {

    /**
     * 最长回文子串
     * 表达式
     *             true,    s[i] == s[j] && j - i <= 3
     * dp[i][j] =  true,    s[i] == s[j] && dp[i + 1][j - 1] == true
     *             false,   others
     */
    public String longestPalindrome(String s) {
        // 空判断
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        // 结果值左右边界
        int left = 0;
        int right = 0;
        // dp[i][j] 表示 s[i] 到 s[j] 是否为一个回文子串
        boolean[][] dp = new boolean[length][length];

        for (int i = length - 2; i >= 0; i--) {
            // 一个字符肯定是回文串
            dp[i][i] = true;
            for (int j = i + 1; j < length; j++) {
                // 首先判断两个字符相等
                if (s.charAt(i) == s.charAt(j)) {
                    // 由于 ABA、AA、A 肯定是回文串，因此 j - i > 3
                    if (j - i < 3 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        // 分别记录左右两个边界
                        if ((j - i) > (right - left)) {
                            left = i;
                            right = j;
                        }
                    }
                }
            }
        }

        return s.substring(left, right + 1);
    }
}
