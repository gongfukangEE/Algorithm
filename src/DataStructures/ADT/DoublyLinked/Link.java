package DataStructures.ADT.DoublyLinked;

/**
 * @Auther gongfukang
 * @Date 2017/12/7 10:51
 */
public class Link {
    public long dData;
    public Link next;
    public Link previous;

    public Link(long d){
        dData=d;
    }

    public void displayLink(){
        System.out.println(dData+" ");
    }
}
