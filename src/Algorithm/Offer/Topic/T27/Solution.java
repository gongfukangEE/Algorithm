package Algorithm.Offer.Topic.T27;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther gongfukang
 * @Date 1/18 15:02
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abcd";
        ArrayList<String> list = solution.Permutation(str);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    private ArrayList<String> ret = new ArrayList<String>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0 || str == null) {
            return ret;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuffer());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuffer s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            // 保证不重复
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) {
                continue;
            }
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            hasUsed[i] = false;
        }
    }
}
