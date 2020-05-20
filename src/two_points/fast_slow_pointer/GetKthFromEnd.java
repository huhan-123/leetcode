package two_points.fast_slow_pointer;

/**
 * @Author: huhan
 * @Date 2020/5/17 8:40 上午
 * @Description 寻找链表的倒数第 k 个元素
 * @Verion 1.0
 */
//思路：让快指针先走K步，然后快慢指针以相同的速度走，当快指针到达链表末尾时，慢指针到达倒数第K个节点
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast, slow;
        fast = slow = head;
        while (fast.next != null && k > 0) {
            k--;
            fast = fast.next;
        }
        if (k > 0) {
            return null;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
