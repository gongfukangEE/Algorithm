package Algorithm.LeetCode.TwoPonits.T680;

/**
 * @auther G.Fukang
 * @date 3/9 23:07
 */
public class Solution {

    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(new Solution().validPalindrome(s));
    }
    public boolean validPalindrome(String s) {
        int start = -1;
        int end = s.length();
        while (++start < --end)
            if (s.charAt(start) != s.charAt(end))
               return isValidPalindrome(s, start, end - 1) || isValidPalindrome(s, start + 1, end);
        return true;
    }

    private boolean isValidPalindrome(String s, int i, int j) {
        while (i < j)
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        return true;
    }
}
