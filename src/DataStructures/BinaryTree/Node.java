package BinaryTree;

/**
 * @Auther gongfukang
 * @Date 2017/12/8 10:00
 */
public class Node {
    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public void displayNode(){
        System.out.print('{');
        System.out.print(iData);
        System.out.print(',');
        System.out.print(dData);
        System.out.print('}');
    }
}
