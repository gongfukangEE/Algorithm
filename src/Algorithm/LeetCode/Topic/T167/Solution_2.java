package Algorithm.LeetCode.Topic.T167;

/**
 * @Auther gongfukang
 * @Date 6/14 23:11
 */
class Solution_2 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] index = new int[2];
        while(i < j) {
            if (numbers[i] + numbers[j] == target) {
                index[0] = i + 1;
                index[1] = j + 1;
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return index;
    }
}