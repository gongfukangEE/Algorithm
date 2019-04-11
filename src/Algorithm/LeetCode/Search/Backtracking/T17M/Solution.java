package Algorithm.LeetCode.Search.Backtracking.T17M;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 4/10 21:37
 */
public class Solution {


    /**
     * 递归终止条件：resString.length() == digits.length()
     *
     * @author G.Fukang
     * @date: 4/11 10:03
     */
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> resList = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return resList;
        }
        backtracking(new StringBuilder(), digits);
        return resList;
    }

    private void backtracking(StringBuilder resString, final String digits) {
        if (resString.length() == digits.length()) {
            // 添加一次扫描的结果
            resList.add(resString.toString());
            return;
        }
        int index = digits.charAt(resString.length()) - '0';
        // 当前数组对应的元素
        String curKeys = KEYS[index];
        for (char c : curKeys.toCharArray()) {
            // 添加元素
            resString.append(c);
            // 递归
            backtracking(resString, digits);
            // 删除刚添加的元素
            resString.deleteCharAt(resString.length() - 1);
        }
    }
}
