package Algorithm.LeetCode.T17;

import java.util.List;

/**
 * @Auther gongfukang
 * @Date 6/18 21:23
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        char[] digitsToChar = digits.toCharArray();
        return null;
    }

    /**
     * s 中保存了此时从 digits[0,1,2...,index - 1]翻译得到的椅子字母字符串
     * 寻找和 digits[index]匹配的字母，获得digits[0,...,index]翻译得到的解
     */
    private static void findCombination(char[] digitsToChar, int index, String s) {
       final String[] letterMap = {
                " ",    //0
                "",     //1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz" //9
        };

        char c = digitsToChar[index];
        char[] letters = letterMap[c - '0'].toCharArray();
        for (int i = 0; i < letters.length; i++) {
            findCombination(digitsToChar, index + 1, s + letters[i]);
        }
    }
}
