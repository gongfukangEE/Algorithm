package Algorithm.LeetCode.Topic.T167;

import java.util.Iterator;

/**
 * @auther G.Fukang
 * @date 3/8 22:43
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int[] res = new Solution().twoSum(arr, 13);
        for (int item : res)
            System.out.print(item + " ");
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int n = numbers.length;
        for (int start = 0, end = n - 1; start < n && end >= 0; ) {
            if (numbers[start] + numbers[end] > target)
                end--;
            else if (numbers[start] + numbers[end] < target)
                start++;
            else {
                res[0] = start + 1;
                res[1] = end + 1;
                break;
            }
        }
        return res;
    }
}
