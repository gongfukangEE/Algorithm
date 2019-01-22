package Algorithm.Offer.T47;

/**
 * @Auther gongfukang
 * @Date 1/20 19:32
 */
public class Solution {

    /**
     * 递归
     * && 具有短路原则，即在第一个条件语句为 false 的情况下下不会去执行第二个条件语句
     * 递归的返回条件取非作为 && 的第一个语句，递归的主体转换为第二个条件语句，
     * 当递归的返回条件为 true 的情况下就不会执行递归的主体部分，递归返回
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
