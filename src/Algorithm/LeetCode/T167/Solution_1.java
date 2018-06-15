package Algorithm.LeetCode.T167;

/**
 * @Auther gongfukang
 * @Date 6/14 23:04
 */
class Solution_1 {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int result = target - numbers[i];
            index[1] = (binarySearch(numbers , result, i + 1, numbers.length - 1)) + 1;
            if (index[1] != 0 ) {
                index[0] = i + 1;
                break;
            }
        }
        return index;
    }
    private static int binarySearch(int[] arr, int tar, int l, int r) {
        while(l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == tar)
                return mid;
            if (tar > arr[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}