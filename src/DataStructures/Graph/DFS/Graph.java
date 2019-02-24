package DataStructures.Graph.DFS;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Auther gongfukang
 * @Date 2017/12/25 16:06
 * 图 邻接表/邻接矩阵
 */
public class Graph {
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVertexs;

    public Graph() {
        int MAX_VERTEXS = 20;
        vertexList = new Vertex[MAX_VERTEXS];

        adjMat = new int[MAX_VERTEXS][MAX_VERTEXS];
        nVertexs = 0;

        for (int j = 0; j < MAX_VERTEXS; j++) {
            for (int k = 0; k < MAX_VERTEXS; k++)
                adjMat[j][k] = 0;
        }
    }

    public void addVertex(char lab) {
        vertexList[nVertexs++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public ArrayList<Character> dfs() {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> resList = new ArrayList<>();
        vertexList[0].wasVisited = true;
        resList.add(vertexList[0].label);
        stack.push(0);

        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1)
                stack.pop();
            else {
                vertexList[v].wasVisited = true;
                resList.add(vertexList[v].label);
                stack.push(v);
            }
        }

        for (int j = 0; j < nVertexs; j++)
            vertexList[j].wasVisited = false;

        return resList;
    }

    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVertexs; j++)
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited)
                return j;
        return -1;
    }

    private ArrayList<Character> DFSResList = new ArrayList<>();

    public ArrayList<Character> DFSTraverse() {
        for (int i = 0; i < nVertexs; i++) {
            if (!vertexList[i].wasVisited)
                DFS(i);
        }
        return DFSResList;
    }

    private void DFS(int v) {
        vertexList[v].wasVisited = true;
        DFSResList.add(vertexList[v].label);
        for (int j = 0; j < nVertexs; j++)
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited)
                DFS(j);
        return;
    }
}
