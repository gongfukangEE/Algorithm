package Algorithm.LeetCode.DynamicProgramming.Package.T139M;

import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/24 20:15
 */
public class Solution_II {

    /**
     * 回溯超时，只能使用 DP
     * dp[i] 表示以 s-1 结尾的字符是否可以在字典中被匹配
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        // 第 0 个字符肯定匹配
        dp[0] = true;
        for (int i = 0; i <= length; i++) {
            // dp[i] = false，说明在字典中没有匹配的，直接跳过
            if (!dp[i]) {
                continue;
            }
            for (String str : wordDict) {
                int len = str.length();
                // 不超过字符串长度 && 与字典中的匹配
                if (i + len <= s.length() && str.equals(s.substring(i, i + len))) {
                    dp[i + len] = true;
                }
            }
        }
        return dp[length];
    }
}
