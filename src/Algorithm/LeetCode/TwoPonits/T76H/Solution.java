package Algorithm.LeetCode.TwoPonits.T76H;

/**
 * @auther G.Fukang
 * @date 5/8 19:35
 */
public class Solution {

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        // 统计目标字符串字符出现的次数
        int[] tCount = new int[255];
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }
        // 记录窗口中字符出现的次数
        int[] winCount = new int[255];
        // 窗口最小值
        int begin = -1, end = s.length(), minWinLength = s.length();
        // 匹配字符计数
        int matchCharCount = 0;
        for (int i = 0, start = 0; i < s.length(); i++) {
            // 窗口内每添加一个元素就统计下信息
            winCount[s.charAt(i)]++;
            // 找到一个匹配的字符
            if (winCount[s.charAt(i)] <= tCount[s.charAt(i)]) {
                matchCharCount++;
            }
            // 如果所有字符全部匹配
            if (matchCharCount == t.length()) {
                // 匹配只需要窗口内字符出现的次数 == t 字符出现的次数，将多余的删掉
                while (start < i && winCount[s.charAt(start)] > tCount[s.charAt(start)]) {
                    winCount[s.charAt(start)]--;
                    start++;
                }
                // 此时 start 指向 匹配子串的开头字母，更新窗口信息
                if (i - start < minWinLength) {
                    minWinLength = i - start;
                    begin = start;
                    end = i;
                }
                // 左指针前移，缩减窗口大小，继续寻找匹配子串
                winCount[s.charAt(start)]--;
                matchCharCount--;
                // 子串位置更新
                start++;
            }
        }

        return begin == -1 ? "" : s.substring(begin, end + 1);
    }
}
