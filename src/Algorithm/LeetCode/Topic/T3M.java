package Algorithm.LeetCode.Topic;

/**
 * @auther G.Fukang
 * @date 5/1 20:16
 */
public class T3M {

    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        // 保存各字符出现的频率
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int res = 0;
        while (l < arr.length) {
            if ( r + 1 < arr.length && freq[arr[r + 1]] == 0) {
                freq[arr[++r]]++;
            } else {
                freq[arr[l++]]--;
            }
            res = res < (r - l +1) ? (r - l + 1) : res;
        }
        return res;
    }
}
