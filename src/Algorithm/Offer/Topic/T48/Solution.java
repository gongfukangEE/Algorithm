package Algorithm.Offer.Topic.T48;

/**
 * @Auther gongfukang
 * @Date 1/20 21:44
 */
public class Solution {

    public int Add(int num1, int num2) {
        return  num2 == 0 ? num1 : Add(num1 ^ num2, (num1 & num2) << 1);
    }
}
