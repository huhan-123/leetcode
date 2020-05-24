package reversal_of_linkedList;

/**
 * @Author: huhan
 * @Date 2020/5/23 9:06 下午
 * @Description 反转链表
 * 反转一个单链表
 * @Verion 1.0
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode current=head,previous=null,temp;
        while(current!=null){
            temp = current;
            current = current.next;
            temp.next = previous;
            previous = temp;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = new ReverseList().reverseList(head);
        System.out.println();
    }
}
