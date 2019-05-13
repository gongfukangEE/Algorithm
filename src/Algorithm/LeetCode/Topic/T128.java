package Algorithm.LeetCode.Topic;

import java.util.HashMap;

/**
 * @auther G.Fukang
 * @date 5/13 20:26
 */
public class T128 {

    /**
     * 1. 先排序后直接找到连续序列，O(NlogN)
     * 2. 判断某个数的连续序列时，分别往减小和增大的方向找下一个连续数在不在数组中，然后把两个方向的长度加起来就是包含该数的连续序列
     *     1. hashmap 保存元素，value 值是该元素所在的连续子数组的长度
     *     2. 如果某个元素 item 不在 map 中，则先找 item - 1 元素是不是在 map 中，如果在 map 中，则取出 value 值 left
     *     3. 再找 item + 1 元素之不是在 map 中，如果在，则取出 value 值 right
     *     4. 当前元素 item 所在的连续序列的长度就是 left + right + 1
     *     5. 如果当前连续序列长度大于 max，则更新 max 值
     *     6. 更新 item - 1 和 item + 1 元素所对应的 value 值
     */
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : nums) {
            if (map.containsKey(item)) {
                continue;
            } else {
                int left = map.getOrDefault(item - 1, 0);
                int right = map.getOrDefault(item + 1, 0);

                int curLength = right + left + 1;
                maxLength = curLength > maxLength ? curLength : maxLength;

                map.put(item, curLength);

                // 更新左端点值
                map.put(item - left, curLength);
                // 更新右端点值
                map.put(item + right, curLength);
            }
        }
        return maxLength;
    }
}
