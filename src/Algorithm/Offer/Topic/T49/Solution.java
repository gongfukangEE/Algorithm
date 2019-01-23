package Algorithm.Offer.Topic.T49;

/**
 * @auther G.Fukang
 * @date 1/23 11:44
 */
public class Solution {

    /**
     * @author G.Fukang
     * @date: 1/23 11:59
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '-' || c == '+')) {
                continue;
            }
            if (c < '0' || c > '9') {
                return 0;
            }
            ret = ret * 10 + (c - '0');
        }
        return str.charAt(0) == '-' ? -ret : ret;
    }
}
