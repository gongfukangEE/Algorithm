package Algorithm.LeetCode.DynamicProgramming.T300M;


/**
 * @auther G.Fukang
 * @date 4/24 12:45
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(new Solution().lengthOfLIS(nums));
    }

    /**
     * dp[i] 表示以 Si 为结尾元素的最长上升子序列的长度
     * max 表示在 [0, i] 的子集中，存在的上升子序列的最大值，结尾元素可能是 Si，也可能不是Si
     * 如果 n > i && Sn > Si，则 dp[n] = max + 1  ==> dp[n] = max{dp[i] + 1 | Si < Sn && i < n}
     * 得到所有 dp[i] 后，求 dp[i] 的最大值，便是 [0, n] 最长上升子序列，结尾元素可能是 Sn，也可能不是 Sn
     * nums = {1,3,6,7,9,4,10,5,6}
     * dp   = {1,2,3,4,5,3,6,4,5}
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }

    /**
     * 最长公共子序列
     * 定义一个二维数组 dp 来存储最长公共子序列的长度，其中 dp[i][j] 表示 S1 的前 i 个字符与 S2 的前 j 个字符最长公共子序列的长度，考虑 S1 与 S2 是否相等，分两种情况：
     *  1. S1i == S2j 那么就能在 S1 的前 i - 1 个字符与 S2 的前 j - 1 个字符最长公共子序列的基础上再加上 S1i 这个值，最长公共子序列长度加 1，即 dp[i][j] = dp[i - 1][j - 1] + 1
     *  2. S1i != S2j 此时最长公共子序列为 S1 的前 i - 1 个字符和 S2 的前 j 个字符最长公共子序列，或者 S1 的前 i 个字符和 S2 的前 j-1 个字符最长公共子序列取最大的，
     *      即 dp[i][j] = Max{dp[i - 1][j], dp[i][j - 1]}
     */
    public int lengthOfLCS(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
