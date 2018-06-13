package DataStructures.GraphW.PATH;

/**
 * @Auther gongfukang
 * @Date 2017/12/26 10:10
 */
public class Edge {
    public int srcVert;
    public int destVert;
    public int distance;

    public Edge(int sv, int dv, int d){
        srcVert=sv;
        destVert=dv;
        distance=d;
    }
}
