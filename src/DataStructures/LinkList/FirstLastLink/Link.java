package DataStructures.LinkList.FirstLastLink;

/**
 * @Auther gongfukang
 * @Date 2017/12/5 14:09
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
