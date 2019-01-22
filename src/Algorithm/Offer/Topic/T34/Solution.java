package Algorithm.Offer.Topic.T34;

import java.util.HashMap;

/**
 * @Auther gongfukang
 * @Date 1/19 11:32
 */
public class Solution {

    public static void main(String[] args) {
        String str = "google";
        System.out.println(new Solution().FirstNotRepeatingChar(str));
    }

    /**
     * 1. 统计字符出现的次数
     * 2. 遍历字符串，如果字符出现次数为 1 ，返回下标
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int value = 0;
            if (map.containsKey(str.charAt(i))) {
                value = map.get(str.charAt(i));
            }
            map.put(str.charAt(i), ++value);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
