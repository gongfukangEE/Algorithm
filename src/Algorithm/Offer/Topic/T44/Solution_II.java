package Algorithm.Offer.Topic.T44;

/**
 * @auther G.Fukang
 * @date 2/27 23:04
 */
public class Solution_II {
    public static void main(String[] args) {
        String s = "i am a student.";
        System.out.println(new Solution_II().ReverseSentence(s));
    }

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0)
            return "";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ) {
            int start = i;
            int end = i;
            while (chars[end] != ' ' && end < chars.length - 1) {
                end++;
            }
            if (end == chars.length - 1) {
                reverse(chars, start, end);
                break;
            } else {
                reverse(chars, start, end - 1);
                i = end + 1;
            }
        }
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j)
            swap(chars, i++, j--);
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[j];
        chars[j] = chars[i];
        chars[i] = c;
    }
}
