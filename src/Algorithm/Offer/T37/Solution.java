package Algorithm.Offer.T37;

/**
 * @Auther gongfukang
 * @Date 1/19 15:59
 */
public class Solution {

    /**
     * 二分查找
     * 1. 找到 k 要插入的位置
     * 2. 找到 k+1 要插入的位置
     * 3. 相减
     */
    public int GetNumberOfK(int[] array, int k) {
        int first = binSearch(array, k);
        int last = binSearch(array, k + 1);
        return (first == array.length || array[first] != k) ? 0 : last - first;
    }

    private int binSearch(int[] nums, int k) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= k) {
                h = m;
            } else {
                l = m +1;
            }
        }
        return l;
    }
}
