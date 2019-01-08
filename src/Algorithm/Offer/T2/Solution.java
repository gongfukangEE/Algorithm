package Algorithm.Offer.T2;

/**
 * @Auther gongfukang
 * @Date 1/8 22:37
 * O(N) + O(1)
 */
public class Solution {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello world");
        System.out.println(stringBuffer.toString());
        System.out.println(replaceSpace(stringBuffer));
    }

    /**
     * 1、从前先向后扫描，遇到空格，在尾部补任意两个字符串，使得补充后的字符串长度和替换后的字符串长度相等
     * 2、P1 为原字符串尾部，P2 为现字符串尾部，从后向前扫描，遇到非空格，在 P2 位置补原字符，遇到空格在 P2 位置补 02%
     */
    public static String replaceSpace(StringBuffer str) {

        // 原字符串尾部
        int p1 = str.length() -1;
        for (int i = 0; i<= p1; i++) {
            if (str.charAt(i) == ' ') {
                // 补两个空格
                str.append("  ");
            }
        }
        // 新字符串尾部
        int p2 = str.length() - 1;
        while (p1 >= 0 && p2 > 0) {
            char c = str.charAt(p1--);
            if (c != ' ') {
                str.setCharAt(p2--, c);
            } else {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            }
        }

        return str.toString();
    }
}
