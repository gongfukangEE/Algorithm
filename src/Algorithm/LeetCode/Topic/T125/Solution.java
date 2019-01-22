package Algorithm.LeetCode.Topic.T125;

/**
 * @Auther gongfukang
 * @Date 6/15 9:24
 */
class Solution {
    public boolean isPalindrome(String s) {
        boolean success = true;
        char[] resultChar = s.toUpperCase().toCharArray();
        int index = 0;
        for (int i = 0; i < resultChar.length; i++) {
            if (checked(resultChar[i])) {
                resultChar[index++] = resultChar[i];
            } else {
                continue;
            }
        }
        int i = 0;
        int j = index - 1;
        while (i <= j) {
            if (resultChar[i++] != resultChar[j--]) {
                success = false;
                break;
            }
        }
        return success;
    }
    private static boolean checked(char temp) {
        if (temp >= '0' && temp <= '9' || temp >= 'A' && temp <= 'Z') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Solution test = new Solution();

        System.out.println(test.isPalindrome(s));
    }
}
