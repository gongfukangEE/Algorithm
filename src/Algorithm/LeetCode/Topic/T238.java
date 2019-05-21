package Algorithm.LeetCode.Topic;


/**
 * @auther G.Fukang
 * @date 5/21 22:02
 */
public class T238 {

    /**
     * 1. 分成正序依次相乘、逆序依次相乘
     * 2. 任意一个元素，可以表示为此元素索引前面的累乘 * 索引后面的累乘
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        // 正序 ess[i] 表示 0-i 的乘积
        int[] esc = new int[length];
        // 逆序 desc[i] 表示 length-1 - i 的乘积
        int[] desc = new int[length];
        esc[0] = nums[0];
        desc[length - 1] = nums[length - 1];
        for (int i = 1; i < length; i++) {
            esc[i] = nums[i] * esc[i - 1];
            desc[length - 1 - i] = nums[length - 1 - i] * desc[length - i];
        }

        int[] res = new int[length];
        res[0] = desc[1];
        res[length - 1] = esc[length - 2];
        for (int i = 1; i < length - 1; i++) {
            res[i] = esc[i - 1] * desc[i + 1];
        }
        return res;
    }
}
