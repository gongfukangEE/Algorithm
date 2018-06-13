package DataStructures.Graph.DFS;

/**
 * @Auther gongfukang
 * @Date 2017/12/25 16:57
 */
public class DFSApp {
    public static void main(String[] args) {
        Graph theGraph=new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0,1);
        theGraph.addEdge(1,2);
        theGraph.addEdge(0,3);
        theGraph.addEdge(3,4);

        System.out.print("Visits: ");
        theGraph.dsf();
        System.out.println();
    }
}
