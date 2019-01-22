package Algorithm.Offer.T40;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Auther gongfukang
 * @Date 1/20 10:03
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        Solution solution = new Solution();
        solution.FindNumsAppearOnce(arr, num1, num2);
    }

    /**
     * HashMap 统计出现的次数
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int count = map.get(array[i]);
                map.put(array[i], ++count);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                list.add(array[i]);
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }
}
