package Algorithm.Offer.Topic.T44;

/**
 * @Auther gongfukang
 * @Date 1/20 16:47
 */
public class Solution {

    public static void main(String[] args) {
        String s = "student a am I";
        System.out.println(new Solution().ReverseSentence(s));
    }

    /**
     * 不能使用额外的空间
     * 1. 先旋转每个单词
     * 2. 再旋转这个字符串
     */
    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            swap(c, i++, j--);
        }
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
