package Algorithm.LeetCode.Topic.T11;

/**
 * @Auther gongfukang
 * @Date 6/15 10:02
 */
class Solution {
    public int maxArea(int[] height) {
        int maxV = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int tempV = 0;
            if (height[left] <= height[right]) {
                tempV = (right - left) * height[left];
                left++;
            } else {
                tempV = (right - left) * height[right];
                right--;
            }
            if (maxV <= tempV) {
                maxV = tempV;
            }
        }
        return maxV;
    }

    public static void main(String[] args) {
        int[] arry = {1,2};
        Solution test = new Solution();
        System.out.println(test.maxArea(arry));
    }
}
