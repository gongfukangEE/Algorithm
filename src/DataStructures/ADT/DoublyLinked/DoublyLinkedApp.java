package ADT.DoublyLinked;

/**
 * @Auther gongfukang
 * @Date 2017/12/7 11:16
 * 双向链表
 */
public class DoublyLinkedApp {
    public static void main(String[] args) {
        DoublyLinkedList theList=new DoublyLinkedList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayBackward();
        theList.displayForward();

        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(11);

        theList.displayForward();

        theList.insertAfter(22,77);
        theList.insertAfter(33,88);

        theList.displayForward();
    }
}
