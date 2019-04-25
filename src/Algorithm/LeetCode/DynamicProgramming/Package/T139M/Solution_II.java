package Algorithm.LeetCode.DynamicProgramming.Package.T139M;

import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/24 20:15
 */
public class Solution_II {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String str : wordDict) {
                int len = str.length();
                if (len <= i && str.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }
}
