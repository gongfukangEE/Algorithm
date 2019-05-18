package Algorithm.LeetCode.Topic;

/**
 * @auther G.Fukang
 * @date 5/18 21:31
 */
public class T169 {

    /**
     * 1. 直接使用 hashmap 统计数字出现的次数
     * 2. 摩尔投票算法
     *    由于某个元素出现的次数超过一半，因此每次找到两个不同的元素删掉，最后剩下的元素就是超过半数的元素
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 记录的元素和当前元素相同，统计值 ++
            if (nums[i] == res) {
                count++;
            } else {
                // 记录的元素和当前元素值不相同，则抵消操作
                count--;
            }
            // 每次取两个不同的元素，前面的都抵消了，则从当前开始重新计算
            if (count == 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }
}
