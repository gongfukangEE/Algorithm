package Algorithm.Offer.Topic.T52;


/**
 * @Auther gongfukang
 * @Date 1/21 11:41
 */
public class Solution {

    public static void main(String[] args) {
        char[] str = "".toCharArray();
        char[] pattern = ".*".toCharArray();
        System.out.println(new Solution().match(str, pattern));
    }

    /**
     * 1. 两个字符串都为空，返回 true
     * 2. 第一个不为空，第二个为空，返回 false
     * 3. 第一个为空，第二个不为空，可能 false，可能 true (.*)
     * 4. 匹配：
     *  1. pattern 下一个字符不为 *
     *      1. a-a true
     *      2. a-. true
     *  2. pattern 下一个字符为 *
     *      1. * 匹配 0 个字符 str 不变，pattern 后移两位
     *      2. * 匹配 1 个或多个字符，str 后移，pattern 不变
     *          匹配一个，str 后移，pattern 不变，则相当于跳回 1
     *          匹配多个，str 后移，pattern 不变，则相当于重复 2
     *
     * @author G.Fukang
     * @date: 1/23 16:11
     */
    public boolean match(char[] str, char[] pattern) {
        if (str.equals("") && pattern.equals("")) {
            return true;
        }
        if (!str.equals("") && pattern.equals("")) {
            return false;
        }
        return match(str, pattern, 0, 0);
    }

    private boolean match(char[] str, char[] pattern, int index1, int index2) {

        if (index1 == str.length - 1 && index2 == pattern.length) {
            return true;
        }
        if (pattern[index2 + 1] != '*') {
            if (str[index1] == pattern[index2]
                    || (!str.equals("") && pattern[index2] == '.')) {
                return match(str, pattern, index1++, index2++);
            } else {
                return false;
            }
        } else {
            if (str[index1] == pattern[index2] || (!str.equals("") && pattern[index2] == '.')) {
                return match(str, pattern, index1, index2 + 2)
                        || match(str, pattern, index1++, index2);
            } else {
                return match(str, pattern, index1, index2 + 2);
            }
        }
    }
}
