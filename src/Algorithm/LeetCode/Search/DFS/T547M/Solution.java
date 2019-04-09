package Algorithm.LeetCode.Search.DFS.T547M;

/**
 * @auther G.Fukang
 * @date 4/8 17:12
 */
public class Solution {

    /**
     * 以某一个朋友为起点，一直寻找与其连通的朋友，直到没有连通的，则构成一个朋友圈
     *
     * @author G.Fukang
     * @date: 4/8 23:26
     */
    private int n;
    private boolean[] marked;
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        this.n = M.length;
        this.marked = new boolean[n];
        int resCount = 0;
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                dfs(M, i);
                resCount++;
            }
        }

        return resCount;
    }

    private void dfs(int[][] M, int i) {
        marked[i] = true;
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && !marked[j]) {
                dfs(M, j);
            }
        }
    }
}
