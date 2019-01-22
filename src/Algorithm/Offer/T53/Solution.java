package Algorithm.Offer.T53;

/**
 * @Auther gongfukang
 * @Date 1/21 14:59
 */
public class Solution {

    /**
     * 使用正则表达式
     * 1. () 标记一个子表达式的开始和结束位置，分组
     * 2. *  匹配前面的子表达式零次或多次
     * 3. +  匹配前面的子表达式一次或多次
     * 4. ？ 匹配前面的子表达式零次或一次
     * 5. [] 字符集合
     * 6. \\. 转义后的 .
     * 7. \\d 数字
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
