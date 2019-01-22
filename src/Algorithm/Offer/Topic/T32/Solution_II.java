package Algorithm.Offer.Topic.T32;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther gongfukang
 * @Date 1/18 22:22
 */
public class Solution_II {

    /**
     * 排序
     * 比较 S1+S2 和 S2+S1，小的排前面，重写比较器
     * 注意：Collections.sor 参数为 list
     */
    public String PrintMinNumber(int[] numbers) {
        String ret = "";
        if (numbers.length == 0 || numbers == null) {
            return ret;
        }
        int n = numbers.length;
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = numbers[i] + "";
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + "" + o2).compareTo(o2 + "" + o1);
            }
        });
        for (String item : str) {
            ret += item;
        }
        return ret;
    }
}
