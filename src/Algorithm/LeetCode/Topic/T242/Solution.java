package Algorithm.LeetCode.Topic.T242;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther gongfukang
 * @Date 6/15 16:13
 */
public class Solution {
    public static boolean isAnagram(String s, String t) {
        Set setS = new HashSet();
        Set setT = new HashSet();
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            setS.add(charS[i]);
        }
        for (int j = 0; j < charT.length; j++) {
            setT.add(charT[j]);
        }
        if (setS.equals(setT)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "a";
        System.out.println(isAnagram(s, t));
    }
}
