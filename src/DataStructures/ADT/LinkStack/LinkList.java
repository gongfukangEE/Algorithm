package DataStructures.ADT.LinkStack;

/**
 * @Auther gongfukang
 * @Date 2017/12/5 14:37
 */
public class LinkList {
    private Link first;

    public LinkList(){
        first=null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    public void insertFirst(long dd){
        Link newLink=new Link(dd);
        newLink.next=first;
        first=newLink;
    }

    public long deleterFirst(){
        Link temp=first;
        first=first.next;
        return temp.dData;
    }

    public void displayList(){
        System.out.println("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
