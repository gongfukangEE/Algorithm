package Algorithm.Offer.Topic.T41;

import java.util.ArrayList;

/**
 * @Auther gongfukang
 * @Date 1/20 10:48
 */
public class Solution {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new Solution().FindContinuousSequence(9);
        for (ArrayList item : list) {
            System.out.println(item.toString());
        }
    }

    /**
     * 链表
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> sumList = new ArrayList<ArrayList<Integer>>();
        if (sum == 0) {
            return sumList;
        }
        int cursum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < sum; i++) {
            cursum += i;
            list.add(i);
            while (cursum > sum) {
                cursum -= list.get(0);
                list.remove(0);
            }
            if (cursum == sum) {
                // 若直接 sumList.add(list)，后面对 list 的操作会影响 sumList
                ArrayList<Integer> tempList = (ArrayList<Integer>) list.clone();
                sumList.add(tempList);
            }
        }
        return sumList;
    }

    /**
     * 双指针
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence_II(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1;
        int end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum > sum) {
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                end++;
                curSum += end;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                ret.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }

}
