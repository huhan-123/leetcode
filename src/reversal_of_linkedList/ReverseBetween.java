package reversal_of_linkedList;

/**
 * @Author: huhan
 * @Date 2020/5/23 9:27 下午
 * @Description 反转链表II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转（反转从位置 m 到 n 的链表。请使用一趟扫描完成反转）
 * @Verion 1.0
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n){
            return head;
        }
        ListNode current = head, previous = null, nodeBeforeM, nodeM, temp;
        int i = 1;
        while (i < m) {
            previous = current;
            current = current.next;
            i++;
        }
        nodeBeforeM = previous;
        nodeM = current;
        while (i < n) {
            temp = current;
            current = current.next;
            temp.next = previous;
            previous = temp;
            i++;
        }
        if (nodeM==head){
            head = current;
        }
        nodeM.next = current.next;
        current.next = previous;
        if (nodeBeforeM!=null){
            nodeBeforeM.next = current;
        }
        return head;
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
        ListNode listNode = new ReverseBetween().reverseBetween(head, 2, 4);
        System.out.println();
    }
}