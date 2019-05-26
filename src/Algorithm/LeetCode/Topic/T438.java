package Algorithm.LeetCode.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @auther G.Fukang
 * @date 5/26 19:39
 */
public class T438 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        new T438().findAnagrams(s, p);
    }

    /**
     * 1. 找到 P 的所有异位词，保存到 HashSet 中
     * 2. 遍历 s，逐个匹配，时间复杂度太高
     * 优化：
     * 1. 如果 s 是异位词，则各个字符出现的次数相同
     * 2. 统计 p 个各个字符出现的次数
     * 3. 在 s 中维护一个滑动窗口，统计窗口中字符出现的次数，与 p 对比
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        // 统计 p
        HashMap<Character, Integer> pMap = new HashMap<>();
        // 统计 s
        HashMap<Character, Integer> sMap = new HashMap<>();
        // 初始化 sMap pMap
        for (int i = 0; i < p.length(); i++) {
            int count = pMap.getOrDefault(p.charAt(i), 0);
            pMap.put(p.charAt(i), ++count);
            count = sMap.getOrDefault(s.charAt(i), 0);
            sMap.put(s.charAt(i), ++count);
        }
        int start;
        int end = p.length();
        for (start = 1; end <= s.length(); start++, end++) {
            // 判断
            if (sMap.equals(pMap)) {
                res.add(start - 1);
            }
            if (end == s.length())  break;
            // 删除旧值
            int oldCount = sMap.get(s.charAt(start - 1));
            if (oldCount == 1) {
                sMap.remove(s.charAt(start - 1));
            } else {
                sMap.put(s.charAt(start - 1), oldCount - 1);
            }
            // 更新新值
            int newCount = sMap.getOrDefault(s.charAt(end), 0);
            sMap.put(s.charAt(end), newCount + 1);
        }
        return res;
    }
}
