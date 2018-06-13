package DataStructures.LinkList.LinkList;


/**
 * @Auther gongfukang
 * @Date 2017/12/5 10:19
 * 单链表
 */
public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else{
                previous=current;
                current=previous.next;
            }
        }
        if(current==first){
            first=first.next;
        }else{
            previous.next=current.next;
        }
        return current;
    }

    public void displayList() {
        System.out.println("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
