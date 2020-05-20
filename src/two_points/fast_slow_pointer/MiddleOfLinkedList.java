package two_points.fast_slow_pointer;

/**
 * @Author: huhan
 * @Date 2020/5/17 8:20 上午
 * @Description 寻找链表的中点
 * @Verion 1.0
 */
//思路：快指针和慢指针同时从头节点出发，当快指针到达链表末尾时慢指针到达中间节点
public class MiddleOfLinkedList {
    public ListNode middleOfLinkedList(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
