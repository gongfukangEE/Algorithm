package Algorithm.LeetCode.Topic.T345;

/**
 * @auther G.Fukang
 * @date 3/8 23:11
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i <= j; ) {
            if (isVowel(chars[i]) && !isVowel(chars[j]))
                j--;
            else if (isVowel(chars[j]) && !isVowel(chars[i]))
                i++;
            else if (isVowel(chars[i]) && isVowel(chars[j]))
                swap(chars, i++, j--);
            else {
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        else
            return false;
    }
}
