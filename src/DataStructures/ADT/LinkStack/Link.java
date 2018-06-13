package ADT.LinkStack;

/**
 * @Auther gongfukang
 * @Date 2017/12/6 22:48
 */
public class Link {
    public long dData;
    public Link next;

    public Link(long dd){
        dData=dd;
    }

    public void displayLink(){
        System.out.println(dData+" ");
    }
}
