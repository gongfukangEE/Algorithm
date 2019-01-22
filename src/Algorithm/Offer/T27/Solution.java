package Algorithm.Offer.T27;

import java.util.*;

/**
 * @Auther gongfukang
 * @Date 1/15 22:36
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

    /**
     * 回溯法 abcd 为例
     * 1. 先确定第一个，再确定第二个...
     * 2.                   abcd
     * 3.                   swap(0,0)
     * 4.                   abcd
     * 5.     (1,1)         (1,2)         (1,3)
     * 6.     abcd          acbd          adbc
     * 7. (2,2)   (2,3) (2,2)   (2,3) (2,2)   (2,3)
     * 8. abcd    abcd  acbd    acdb  adbc    adcb
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> resList = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return resList;
        }
        fun(str.toCharArray(), resList, 0);
        Collections.sort(resList);
        return resList;
    }

    public void fun(char[] ch, ArrayList<String> list, int i) {
        // 递归终止条件
        if (i == ch.length - 1) {
            String str = String.valueOf(ch);
            if (!list.contains(str)) {
                list.add(str);
            }
        } else {
            for (int j = i; j <= ch.length - 1; j++) {
                swap(ch, i, j);
                // 递归到最后为：(2,2) (2,3)
                fun(ch, list, i + 1);
                // 执行完后，回退到第 6 行状态，再次执行  swap 后，回退到第 4 行状态，再开始新一轮递归
                swap(ch, i, j);
            }
        }
    }

    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
