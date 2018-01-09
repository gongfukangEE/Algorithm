package Graph.TOPO;

/**
 * @Auther gongfukang
 * @Date 2017/12/25 21:41
 */
public class TopoApp {
    public static void main(String[] args) {
        Graph theGraph=new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');
        theGraph.addVertex('H');

        theGraph.addEdge(0,3);
        theGraph.addEdge(0,4);
        theGraph.addEdge(1,4);
        theGraph.addEdge(2,5);
        theGraph.addEdge(3,6);
        theGraph.addEdge(4,6);
        theGraph.addEdge(5,7);
        theGraph.addEdge(6,7);

        theGraph.topo();
    }
}
