package DataStructures.LinkList.LinkList;

/**
 * @Auther gongfukang
 * @Date 2017/12/5 11:11
 * 单链表
 */
public class LinkListApp {
    public static void main(String[] args) {
        LinkList linkList=new LinkList();
        linkList.insertFirst(22,2.99);
        linkList.insertFirst(44,4.99);
        linkList.insertFirst(66,6.99);
        linkList.insertFirst(88,8.99);

        linkList.displayList();

       Link f=linkList.find(44);
       if(f!=null)
           System.out.println("Found link with key "+f.iData);
       else
           System.out.println("Can't find link");

       Link d=linkList.delete(66);
       if(d!=null)
           System.out.println("Delete link with key "+d.iData);
       else
           System.out.println("Can't delete link");
       linkList.displayList();
    }
}
