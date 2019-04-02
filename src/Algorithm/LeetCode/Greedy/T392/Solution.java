package Algorithm.LeetCode.Greedy.T392;

/**
 * @auther G.Fukang
 * @date 4/2 19:53
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        int si = 0, ti = 0;
        while (si < s.length() && ti < t.length()) {
            if (tChar[ti] == sChar[si]) {
                si++;
                ti++;
            } else {
                ti++;
            }
        }
        return si == s.length();
    }
}
