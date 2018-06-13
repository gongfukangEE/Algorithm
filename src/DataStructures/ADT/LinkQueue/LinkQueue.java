package DataStructures.ADT.LinkQueue;

/**
 * @Auther gongfukang
 * @Date 2017/12/7 9:46
 */
public class LinkQueue {
    private FirstLastList theList;

    public LinkQueue() {
        theList = new FirstLastList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void insert(long j) {
        theList.insetLast(j);
    }

    public long remove(){
        return theList.deleteFirst();
    }

    public void displayQueue(){
        System.out.println("Queue (front -- > rear):");
        theList.dispalyList();
    }
}
