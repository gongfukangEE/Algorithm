package GraphW.MSTW;

/**
 * @Auther gongfukang
 * @Date 2017/12/26 10:26
 */
public class Graph {
    private final int MAX_VERTS=20;
    private final int INFINITY=100000;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private int currentVert;
    private PriorityQ thePQ;
    private int nTree;

    public Graph(){
        vertexList=new Vertex[MAX_VERTS];

        adjMat=new int[MAX_VERTS][MAX_VERTS];
        nVerts=0;
        for(int j=0;j<MAX_VERTS;j++)
            for(int k=0;k<MAX_VERTS;k++)
                adjMat[j][k]=INFINITY;
        thePQ=new PriorityQ();
    }

    public void addVertex(char lab){
        vertexList[nVerts++]=new Vertex(lab);
    }

    public void addEdge(int start,int end,int weight){
        adjMat[start][end]=weight;
        adjMat[end][start]=weight;
    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    public void mstw(){
        currentVert=0;

        while (nTree<nVerts){
            vertexList[currentVert].isInTree=true;
            nTree++;

            for(int j=0;j<nVerts;j++){
                if(j==currentVert)
                    continue;
                if(vertexList[j].isInTree)
                    continue;
                int distance=adjMat[currentVert][j];
                if(distance==INFINITY)
                    continue;
                putInPQ(j,distance);
            }
            if(thePQ.size()==0){
                System.out.println("GRAPH NOT CONNECTED");
                return;
            }

            Edge theEdge=thePQ.removeMin();
            int sourceVert=theEdge.srcVert;
            currentVert=theEdge.destVert;

            System.out.print(vertexList[sourceVert].label);
            System.out.print("->");
            System.out.print(vertexList[currentVert].label);
            System.out.print("  ");
        }

        for(int j=0;j<nVerts;j++)
            vertexList[j].isInTree=false;
    }

    public void putInPQ(int newVert,int newDist){
        int queueIndex=thePQ.find(newVert);
        if(queueIndex!=-1){
            Edge tempEdge=thePQ.peekN(queueIndex);
            int oldDist=tempEdge.distance;
            if(oldDist>newDist){
                thePQ.removeN(queueIndex);
                Edge theEdge=new Edge(currentVert,newVert,newDist);
                thePQ.insert(theEdge);
            }
        }else{
            Edge theEdge=new Edge(currentVert,newVert,newDist);
            thePQ.insert(theEdge);
        }
    }
}
