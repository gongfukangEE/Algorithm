package Algorithm.LeetCode.Topic;

/**
 * @auther G.Fukang
 * @date 5/13 20:09
 */
public class T136 {
    /**
     * 1. 直接使用 hashmap，出现次数为奇数的记录下来
     * 2. 使用异或 ^
     *      相同为假，不同为真，任何一个元素异或自己都为 0
     *      从头到尾依次异或数组中的每一个数字，那么最终的结果刚好是那个只出现一次的数字，
     *      因为那些出现两次的数字全部在异或中抵消掉了
     */

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int item : nums) {
            res ^= item;
        }
        return res;
    }
}
