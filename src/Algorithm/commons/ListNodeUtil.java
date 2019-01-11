package Algorithm.commons;

/**
 * @Auther gongfukang
 * @Date 6/15 21:52
 */
public class ListNodeUtil {

    // 尾插法建立链表
    public ListNode createListNode (int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    public void displayList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }
}
