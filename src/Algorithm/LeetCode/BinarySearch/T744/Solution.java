package Algorithm.LeetCode.BinarySearch.T744;

/**
 * @auther G.Fukang
 * @date 4/7 21:51
 */
public class Solution {

    public static void main(String[] args) {
        char[] letters = new String("eeeeennnnn").toCharArray();
        char target = 'e';
        System.out.println(new Solution().nextGreatestLetter(letters, target));
    }


    /**
     * 找到 target + 1 要插入的位置
     *
     * @author G.Fukang
     * @date: 4/7 23:12
     */
    public char nextGreatestLetter(char[] letters, char target) {
        char temp = (char) (target + 1);
        int l = 0;
        int h = letters.length;
        while (l < h) {
            int mid = (l + h) / 2;
            if (letters[mid] < temp) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l < letters.length ? letters[l] : letters[0];
    }
}
