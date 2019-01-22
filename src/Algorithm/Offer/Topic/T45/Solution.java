package Algorithm.Offer.Topic.T45;

import java.util.Arrays;

/**
 * @Auther gongfukang
 * @Date 1/20 19:32
 */
public class Solution {

    /**
     * 1. 排序
     * 2. 统计大小王
     * 3. 大小王补有序数列
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int count = 0;
        for (int item : numbers) {
            if (item == 0) {
                count++;
            }
        }
        for (int i = count; i < numbers.length - 1; i++) {
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            count -= (numbers[i + 1] - numbers[i] - 1);
        }
        return count >= 0;
    }
}
