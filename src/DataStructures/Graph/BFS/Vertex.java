package Graph.BFS;

/**
 * @Auther gongfukang
 * @Date 2017/12/25 16:05
 * 顶点
 */
public class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab){
        label=lab;
        wasVisited=false;
    }
}
