package Algorithm.LeetCode.Topic.T3;

/**
 * @Auther gongfukang
 * @Date 6/15 13:09
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        // 保存各字符出现的频率
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int res = 0;
        while (l < arr.length) {
            // 如果有重复字符，缩小左边界，否则拓展右边界
            if ( r + 1 < arr.length && freq[arr[r + 1]] == 0) {
                freq[arr[++r]]++;
            } else {
                freq[arr[l++]]--;
            }
            res = res < (r - l +1) ? (r - l + 1) : res;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        Solution test = new Solution();
        System.out.println(test.lengthOfLongestSubstring(s));
    }
}