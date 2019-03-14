package Algorithm.LeetCode.TwoPonits.T524M;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 3/14 20:10
 */
public class Solution {

    public static void main(String[] args) {
        String s = "abpcplea";
        String[] d = {"a","b","c"};
        ArrayList<String> list = new ArrayList<>();
        for (String string : d)
            list.add(string);
        System.out.println(new Solution().findLongestWord(s, list));
    }

    private char[] chars;

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        if (s != null && s.length() != 0) {
            chars = s.toCharArray();
            for (String target : d) {
                int resLength = res.length();
                int targetLength = target.length();
                if (resLength > targetLength || (resLength == targetLength && res.compareTo(target) < 0))
                    continue;
                if (isCommonWord(target.toCharArray()))
                    res = target;
            }
        }
        return res;
    }

    private boolean isCommonWord(char[] dchars) {
        int i = 0, j = 0;
        while (i < chars.length && j < dchars.length) {
            if (chars[i] == dchars[j]) {
                j++;
            }
            i++;
        }
        return j == dchars.length;
    }
}
