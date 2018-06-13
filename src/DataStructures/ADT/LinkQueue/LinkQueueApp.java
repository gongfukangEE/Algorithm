package ADT.LinkQueue;

/**
 * @Auther gongfukang
 * @Date 2017/12/7 9:53
 * 链表实现队列
 */
public class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue theQuee=new LinkQueue();
        theQuee.insert(20);
        theQuee.insert(40);

        theQuee.displayQueue();

        theQuee.insert(60);
        theQuee.insert(80);

        theQuee.displayQueue();

        theQuee.remove();
        theQuee.remove();

        theQuee.displayQueue();
    }
}
