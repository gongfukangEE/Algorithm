package DataStructures.ADT.LinkStack;

/**
 * @Auther gongfukang
 * @Date 2017/12/7 9:34
 * 链表实现栈
 */
public class LinkStackApp {
    public static void main(String[] args) {
        LinkStack linkStack=new LinkStack();
        linkStack.push(20);
        linkStack.push(40);

        linkStack.displayStack();

        linkStack.push(60);
        linkStack.push(80);

        linkStack.displayStack();

        linkStack.pop();
        linkStack.pop();

        linkStack.displayStack();
    }
}
