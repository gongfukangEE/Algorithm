package Algorithm.LeetCode.DynamicProgramming.Package.T139M;

import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/24 20:00
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0 || wordDict.size() == 0) {
            return false;
        }
        return doWordBreak(s, wordDict, 0);
    }

    private boolean doWordBreak(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (String str : wordDict) {
            int strLength = str.length();
            int end = start + strLength;
            if (end > s.length())   continue;
            String strTemp = s.substring(start, end);
            if (strTemp.equals(str)) {
                if (doWordBreak(s, wordDict, end)) {
                    return true;
                }
            }
        }
        return false;
    }
}
