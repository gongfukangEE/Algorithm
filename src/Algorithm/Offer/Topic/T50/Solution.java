package Algorithm.Offer.Topic.T50;

/**
 * @Auther gongfukang
 * @Date 1/20 22:03
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        int[] duplication = new int[1];
        System.out.println(new Solution().duplicate(arr, 7, duplication));
    }

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0) {
            return false;
        }
        int[] arr = new int[length];
        duplication[0] = -1;
        for (int i = 0; i < length; i++) {
            ++arr[numbers[i]];
            if (arr[numbers[i]] >= 2) {
                duplication[0] = numbers[i];
                break;
            }
        }
        if (duplication[0] != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 复杂度为 O(N) + O(1)
     * 将值 i 调整到第 i 个位置上，若该位置有数字，则说明此值重复
     */
    public boolean duplicate_I(int numbers[],int length,int [] duplication) {
        if (numbers == null || length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private void swap(int[] arr, int i,int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
