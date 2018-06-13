package LinkList.LinkList;

/**
 * @Auther gongfukang
 * @Date 2017/12/5 10:47
 * 链结点
 */
public class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int id,double dd){
        iData=id;
        dData=dd;
    }

    public void displayLink(){
        System.out.println("{"+iData+","+dData+"}");
    }
}
