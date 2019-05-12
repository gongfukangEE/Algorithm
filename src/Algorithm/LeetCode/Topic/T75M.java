package Algorithm.LeetCode.Topic;

/**
 * @auther G.Fukang
 * @date 5/8 19:23
 */
public class T75M {

    /**
     * 计数排序
     */
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        // 统计 0 1 2 出现的次数
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int index =0;
        for (int i = 0; i < nums.length; i++) {
            nums[index++] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[index++] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[index++] = 2;
        }
    }
}
