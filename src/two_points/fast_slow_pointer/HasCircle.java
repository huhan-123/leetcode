package two_points.fast_slow_pointer;

/**
 * @Author: huhan
 * @Date 2020/5/16 9:43 下午
 * @Description 给定一个链表，判断链表中是否有环。
 * @Verion 1.0
 */
public class HasCircle {
    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}

