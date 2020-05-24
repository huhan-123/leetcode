package reversal_of_linkedList;

import java.util.LinkedList;

/**
 * @Author: huhan
 * @Date 2020/5/23 10:29 下午
 * @Description K个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * @Verion 1.0
 */
//程序写的很乱，下次再写一遍，大致思路如下：找到一组k个节点，翻转，然后再找下一组，如果一组不满k个节点，直接返回
public class ReverseGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode first = head, firstBefore = null, current = head, lastAfter;
        int count;
        while (first != null) {
            count=1;
            //从first开始找后面第k个节点
            while (current != null && count < k) {
                current = current.next;
                count++;
            }

            if (current == null) {
                return head;
            }

            lastAfter = current.next;
            reverse(first, lastAfter);
            if (first == head) {
                head = current;
            }
            if (firstBefore != null) {
                firstBefore.next = current;
            }
            first.next = lastAfter;
            firstBefore = first;
            first = lastAfter;
            current = first;
        }

        return head;
    }

    public void reverse(ListNode first, ListNode last) {
        ListNode current = first, previous = null, temp;
        while (current != last) {
            temp = current;
            current = current.next;
            temp.next = previous;
            previous = temp;
        }
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

        ListNode node = new ReverseGroup().reverseKGroup(head, 2);
        System.out.println();
    }
}
