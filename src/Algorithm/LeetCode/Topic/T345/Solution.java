package Algorithm.LeetCode.Topic.T345;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @auther G.Fukang
 * @date 3/8 23:11
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("leetcode"));
    }

    private HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i <= j) {
            char ci = chars[i];
            char cj = chars[j];
            if (!set.contains(ci))
                chars[i++] = ci;
            else if (!set.contains(cj))
                chars[j--] = cj;
            else {
                chars[i++] = cj;
                chars[j--] = ci;
            }
        }
        return new String(chars);
    }
}
