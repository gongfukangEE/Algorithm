package Algorithm.Offer.Topic.T35;

/**
 * @Auther gongfukang
 * @Date 1/19 13:33
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(new Solution().InversePairs(arr));
    }

    private long count = 0;
    private int[] copy;
    public int InversePairs(int[] array) {
        copy = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return (int) (count % 1000000007);
    }

    private void mergeSort(int[] arr, int l, int h) {
        if (l >= h)
            return;
        int mid = l + (h - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, h);
        merge(arr, l, mid, h);
    }
    private void merge(int[] arr, int l , int m, int h) {
        int i = l;
        int j = m + 1;
        for (int k = l; k <= h; k++)
            copy[k] = arr[k];
        for (int k = l; k <= h; k++) {
            if (i > m)
                arr[k] = copy[j++];
            else if (j > h)
                arr[k] = copy[i++];
            else if (copy[i] < arr[j])
                arr[k] = copy[i++];
            else {
                arr[k] = copy[j++];
                count += m - i + 1;
            }
        }
    }
}
