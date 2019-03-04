package Algorithm.Offer.Topic.T52;

/**
 * @auther G.Fukang
 * @date 3/4 19:34
 */
public class Solution_II {

    public static void main(String[] args) {
        char[] str = "aaa".toCharArray();
        char[] pattern = "ab*ac*a".toCharArray();
        System.out.println(new Solution_II().match(str, pattern));
    }

    public boolean match(char[] str, char[] pattern) {
        int m = str.length;
        int n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*'){
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        // 匹配 0 个
                        dp[i][j] |= dp[i][j - 2];
                        // 匹配 1 个
                        dp[i][j] |= dp[i][j - 1];
                        // 匹配多个
                        dp[i][j] |= dp[i - 1][j];
                    } else {
                        // 仅仅匹配 0 个
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
