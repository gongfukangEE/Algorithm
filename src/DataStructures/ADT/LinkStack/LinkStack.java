package DataStructures.ADT.LinkStack;

/**
 * @Auther gongfukang
 * @Date 2017/12/5 15:46
 */
public class LinkStack {
    private LinkList theList;

    public LinkStack(){
        theList=new LinkList();
    }

    public void push(long j){
        theList.insertFirst(j);
    }

    public long pop(){
        return theList.deleterFirst();
    }

    public boolean isEmpty(){
        return theList.isEmpty();
    }

    public void displayStack(){
        System.out.println("top --> : ");
        theList.displayList();
    }
}
