package Algorithm.LeetCode.Graph.T207;

import java.util.ArrayList;

/**
 * @auther G.Fukang
 * @date 5/19 22:31
 */
public class Solution {


    /**
     * 给定的学习条件可以表示为一个图，如果可以排课则图中没有环
     * 问题转化为判读图中是否有环
     * DFS 来判断图中的环
     * 沿着一个节点，深度遍历，每遍历一个就记录下来，如果任意一条路径出现遍历到被遍历过的节点，就返回 true
     */
    private ArrayList<ArrayList<Integer>> graph;
    private boolean[] marked;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();
        marked = new boolean[numCourses];
        // 初始化图
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // 填充图
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            graph.get(course).add(preCourse);
        }

        for (int i = 0; i < numCourses; i++) {
            if (DFS(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean DFS(int cur) {
        // 递归终止条件
        if (marked[cur]) {
            return true;
        }

        // 标记节点
        marked[cur] = true;
        for (int item : graph.get(cur)) {
            if (DFS(item)) {
                return true;
            }
        }
        // 取消标记
        marked[cur] = false;
        // 说明此路径无环
        return false;
    }
}
