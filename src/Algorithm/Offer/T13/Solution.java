package Algorithm.Offer.T13;

/**
 * @Auther gongfukang
 * @Date 1/12 15:49
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i< 20; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        reOrderArray(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    public static void reOrderArray(int[] array) {
        int oddCont = 0;
        for (int item : array) {
            if (item % 2 == 1) {
                ++oddCont;
            }
        }
        int[] copy = array.clone();
        int i = 0;
        for (int item : copy) {
            if (item %2 ==1) {
                array[i++] = item;
            } else {
                array[oddCont++] = item;
            }
        }
    }
}
