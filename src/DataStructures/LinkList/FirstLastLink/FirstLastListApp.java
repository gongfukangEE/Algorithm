package DataStructures.LinkList.FirstLastLink;

/**
 * @Auther gongfukang
 * @Date 2017/12/5 14:20
 * 双端链表
 */
public class FirstLastListApp {
    public static void main(String[] args) {
        FirstLastList firstLastList=new FirstLastList();
        firstLastList.insertFirst(22);
        firstLastList.insertFirst(44);
        firstLastList.insertFirst(66);

        firstLastList.insertLast(11);
        firstLastList.insertLast(33);
        firstLastList.insertLast(55);

        firstLastList.displayList();

        firstLastList.deleterFirst();
        firstLastList.deleterFirst();

        firstLastList.displayList();
    }
}
