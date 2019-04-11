package Algorithm.LeetCode.Search.Backtracking.T93M;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/11 10:30
 */
public class Solution {

    public static void main(String[] args) {
        String s = "25525511135";
        for (String str : new Solution().restoreIpAddresses(s)) {
            System.out.println(str);
        }
    }

    private List<String> resList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) {
            return resList;
        }
        backtracking(new StringBuilder(),0, s);
        return resList;
    }

    private void backtracking(StringBuilder resString,int count, final String s) {
        // 递归终止条件
       if (count == 4 || s.length() == 0) {
           if (count == 4 && s.length() == 0) {
               resList.add(resString.toString());
           }
           return;
       }
       for (int i = 0; i < s.length() && i <=2; i++) {
           if (i != 0 && s.charAt(0) == '0') {
               break;
           }
           String part = s.substring(0, i + 1);
           if (Integer.valueOf(part) <= 255) {
               if (resString.length() != 0) {
                   part = "." + part;
               }
               resString.append(part);
               backtracking(resString, count + 1, s.substring(i + 1));
               // 删除元素
               resString.delete(resString.length() - part.length(), resString.length());
           }
       }
    }
}
