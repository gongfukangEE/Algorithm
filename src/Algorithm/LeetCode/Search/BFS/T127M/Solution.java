package Algorithm.LeetCode.Search.BFS.T127M;

import java.util.*;

/**
 * @auther G.Fukang
 * @date 4/8 12:32
 */
public class Solution {

    public static void main(String[] args) {
        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = Arrays.asList("a", "b", "c");
        System.out.println(new Solution().ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 首先判断 endWord
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 队列
        Queue<String> queue = new LinkedList<>();
        // 计数
        int resCount = 0;
        // 禁忌表
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for (String item : wordList) {
            map.put(item, false);
        }
        // beginWord 开始
        queue.add(beginWord);
        map.put(beginWord, true);
        while (!queue.isEmpty()) {
            ++resCount;
            int size = queue.size();
            String curString = queue.poll();
            while (size-- > 0) {
                for (String item : wordList) {
                    if (!map.get(item) && canConversion(item, curString)) {
                        if (item.equals(endWord)) {
                            return resCount;
                        }
                        map.put(item, true);
                        queue.add(item);
                    }
                }
            }
        }
        return wordList.size();
    }

    private boolean canConversion(String wordStart, String wordEnd) {
        int res = 0;
        for (int i = 0; i < wordStart.length(); i++) {
            if (wordStart.charAt(i) != wordEnd.charAt(i)) {
                ++res;
            }
            if (res > 1) {
                break;
            }
        }
        return res == 1;
    }
}
