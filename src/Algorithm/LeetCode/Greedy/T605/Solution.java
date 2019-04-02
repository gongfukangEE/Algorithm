package Algorithm.LeetCode.Greedy.T605;

/**
 * @auther G.Fukang
 * @date 4/2 19:19
 */
public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) {
            return false;
        }
        if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) {
            return true;
        }
        int pre = 0, cur = 0, next = 1;
        while (next < flowerbed.length) {
            if (flowerbed[pre] == 0 && flowerbed[cur] == 0 && flowerbed[next] == 0) {
                --n;
                flowerbed[cur] = 1;
            }
            pre = cur;
            cur = next;
            next++;
        }

        // 判断边界
        if (flowerbed[pre] == 0 && flowerbed[cur] == 0) {
            --n;
        }

        return n <= 0;
    }
}
