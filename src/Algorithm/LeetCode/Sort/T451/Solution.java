package Algorithm.LeetCode.Sort.T451;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @auther G.Fukang
 * @date 4/2 9:42
 */
public class Solution {

    public static void main(String[] args) {
        String s = "cacaca";
        System.out.println(new Solution().frequencySort(s));
    }

    public String frequencySort(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        if (s == null || s.length() == 0) {
            return stringBuilder.toString();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        ArrayList<Character>[] buckets = new ArrayList[s.length() + 1];
        for (Character ch : map.keySet()) {
            int frequence = map.get(ch);
            if (buckets[frequence] == null) {
                buckets[frequence] = new ArrayList<>();
            }
            buckets[frequence].add(ch);
        }
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                while (buckets[i].size() > 0) {
                    int count = i;
                    while (count-- > 0) {
                        stringBuilder.append(buckets[i].get(0));
                    }
                    buckets[i].remove(0);
                }
            }
        }
        return stringBuilder.toString();
    }
}
