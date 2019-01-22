package Algorithm.Offer.Topic.T32;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Auther gongfukang
 * @Date 1/18 21:48
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {3, 32, 321};
        System.out.println(new Solution().PrintMinNumber(arr));
    }

    /**
     * 回溯法
     */
    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> ret = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        backTracing(strs, ret, 0);
        Collections.sort(ret);
        return ret.get(0).toString();
    }

    private void backTracing(String[] str, ArrayList<String> list, int i){
        if (i == str.length - 1) {
            StringBuffer s = new StringBuffer();
            for (String item : str) {
                s.append(item);
            }
            if (!list.contains(s.toString())) {
                list.add(s.toString());
            }
        } else {
            for (int j = i; j < str.length; j++) {
                swap(str, j, i );
                backTracing(str, list, i + 1);
                swap(str, j, i);
            }
        }
    }

    private void swap(String[] str, int j, int i) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
