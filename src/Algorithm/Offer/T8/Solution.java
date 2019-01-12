package Algorithm.Offer.T8;

/**
 * @Auther gongfukang
 * @Date 1/12 10:15
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
    }

    /**
     * 空间复杂度 O(1)
     */
    public static int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int pre1 = 1;
        int pre2 = 2;
        int result = 1;
        for (int i = 3; i <= target; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }

    /**
     * 空间复杂度 O(N)
     */
    public static int JumpFloorArr(int target) {
        if (target <= 2) {
            return target;
        }
        int[] result = new int[target + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i < target + 1; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[target];
    }
}
