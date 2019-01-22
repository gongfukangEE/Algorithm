package Algorithm.Offer.Topic.T43;


/**
 * @Auther gongfukang
 * @Date 1/20 15:58
 */
public class Solution {

    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(new Solution().LeftRotateString(str, 3));
    }

    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = n; i < chars.length; i++) {
            stringBuffer.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            stringBuffer.append(chars[i]);
        }
        return stringBuffer.toString();
    }

    /**
     * 1. 反转 n 前部分的字符串，反转 n 后部分的字符串，得到新的字符串 temp
     * 2. 反转新的字符串 temp
     */
    public String LeftRotateString_I(String str, int n) {
        if (n >= str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
