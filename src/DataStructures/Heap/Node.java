package DataStructures.Heap;

/**
 * @Auther gongfukang
 * @Date 2017/12/24 10:05
 */
public class Node {
    private int iData;

    public Node(int key){
        iData=key;
    }

    public int getKey(){
        return iData;
    }

    public void setKey(int id){
        iData=id;
    }
}
