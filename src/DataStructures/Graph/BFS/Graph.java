package DataStructures.Graph.BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther gongfukang
 * @Date 2017/12/25 16:06
 * 图 邻接表/邻接矩阵
 */
public class Graph {
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;

    public Graph() {
        int MAX_VERTS = 20;
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k] = 0;
        }
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    private ArrayList<Character> resList = new ArrayList<>();

    public ArrayList<Character> bfs() {
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].wasVisited = true;
        resList.add(vertexList[0].label);
        queue.add(0);
        int v2;

        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                resList.add(vertexList[v2].label);
                queue.add(v2);
            }
        }

        for (int j = 0; j < nVerts; j++)
            vertexList[j].wasVisited = false;

        return resList;
    }

    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++)
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited)
                return j;
        return -1;
    }
}
