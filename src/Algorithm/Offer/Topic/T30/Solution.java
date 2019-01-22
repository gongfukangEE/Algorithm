package Algorithm.Offer.Topic.T30;

/**
 * @Auther gongfukang
 * @Date 1/18 17:20
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        System.out.println(new Solution().FindGreatestSumOfSubArray(arr));
    }

    /**
     * 动态规划
     * 如果arr[i] 左边最大子数组的和为非负数，则对 maxsum 贡献为正；反正贡献为负
     * 1. 以 arr[i - 1] 为末尾的子数组的和的最大值 sum
     * 2. 以 arr[i] 为末尾的子数组的和的最大值 maxsum
     * 3. sum = MAX(lastsum ,sum)
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;
        for (int item : array) {
            if (sum >= 0) {
                sum += item;
            } else {
                sum = item;
            }
            maxsum = Math.max(maxsum, sum);
        }
        return maxsum;
    }
}
