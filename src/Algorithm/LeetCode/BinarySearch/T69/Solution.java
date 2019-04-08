package Algorithm.LeetCode.BinarySearch.T69;

/**
 * @auther G.Fukang
 * @date 4/7 21:28
 */
public class Solution {

    public static void main(String[] args) {
        int num = 8;
        System.out.println(new Solution().mySqrt(num));
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 1, h = x;
        while (l <= h) {
            int mid = (l + h) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt < mid) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }
}
