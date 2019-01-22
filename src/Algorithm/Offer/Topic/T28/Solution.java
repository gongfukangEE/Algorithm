package Algorithm.Offer.Topic.T28;

import java.util.Hashtable;

/**
 * @Auther gongfukang
 * @Date 1/18 15:44
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(solution.MoreThanHalfNum_Solution_II(arr));
    }

    /**
     * Hashtable 使用 O(N)
     */
    public int MoreThanHalfNum_Solution_I(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Hashtable<Integer, Integer> table = new Hashtable<>();
        for (int item : array) {
            int count = 1;
            if (table.containsKey(item)) {
                count = table.get(item);
                table.put(item, ++count);
            } else {
                table.put(item, count);
            }
            if (count > array.length / 2) {
                return item;
            } else {
                continue;
            }
        }
        return 0;
    }

    /**
     * 摩尔投票算法
     * 1. 每次从数组中找出一对不同的元素，将它们从数组中删除，直到遍历完整个数组。
     * 2. 使用 count 来统计一个元素出现的次数，当遍历到的元素和统计元素相等时，令 count++，否则 count--
     * 3. 如果前面查找了 i 个元素，且 count == 0，说明前 i 个元素没有 maijority，或者存在但小于 i/2
     * 4. 剩下的 n-i 个元素中，majority 的数目依然多于 (n-i)/2
     */
    public int MoreThanHalfNum_Solution_II(int[] array) {
        int majority = array[0];
        for (int i = 1,count = 1; i < array.length; i++) {
            count = (array[i] == majority ? count + 1 : count - 1);
            if (count == 0) {
                majority = array[i];
                count = 1;
            }
        }
        int count = 0;
        for (int item : array) {
            if (item == majority) {
                count++;
            }
        }
        return count > array.length / 2 ? majority : 0;
    }
}
