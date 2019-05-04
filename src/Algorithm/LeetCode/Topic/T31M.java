package Algorithm.LeetCode.Topic;



/**
 * @auther G.Fukang
 * @date 5/4 18:54
 */
public class T31M {

    /**
     * 1 4 5 3 2
     * 从后向前找一个递增序列，直到出现非递增的元素，为 4
     * 从后向前找第一个比非递归的元素大的元素，为 5
     * 交换两个元素   1 5 4 3 2
     * 将前面出现的非递归元素的后面元素反转   1 5 2 3 4
     */
    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            // 非递减序列
            if (nums[i] <= nums[i - 1]) {
                continue;
            } else {
                // 非递增元素
                for (int j = nums.length - 1; j > i - 1; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(i - 1, j, nums);
                        // 数组反转
                        reverse(i, nums.length - 1, nums);
                        return;
                    } else {
                        continue;
                    }
                }
            }
        }
        // 没有符合条件的元素，全部反转
        reverse(0, nums.length - 1, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int begin, int end, int[] nums) {
        while (begin <= end) {
            swap(begin++, end--, nums);
        }
    }
}
