package ADT.LinkQueue;

/**
 * @Auther gongfukang
 * @Date 2017/12/7 9:37
 */
public class Link {
    public long dData;
    public Link next;

    public Link(long d){
        dData=d;
    }

    public void displayLink(){
        System.out.println(dData+" ");
    }
}
