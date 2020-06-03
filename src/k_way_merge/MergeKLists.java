package k_way_merge;

import reversal_of_linkedList.ListNode;

import java.util.PriorityQueue;

/**
 * @Author: huhan
 * @Date 2020/6/2 3:30 下午
 * @Description 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。
 * @Verion 1.0
 */

/**
 * 思路：
 * 1.把每个数组中的第一个元素都加入最小堆中
 * 2.取出堆顶元素（全局最小），将该元素放入排好序的结果集合里面
 * 3.将刚取出的元素所在的数组里面的下一个元素加入堆
 * 4.重复步骤2，3，直到处理完所有数字
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head;
        PriorityQueue<ListNode> littleQueue = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode node : lists) {
            if (node != null) {
                littleQueue.offer(node);
            }
        }

        head = littleQueue.poll();
        if (head.next != null) {
            littleQueue.offer(head.next);
        }
        ListNode current, pre;
        pre = head;
        while (!littleQueue.isEmpty()) {
            current = littleQueue.poll();
            pre.next = current;
            pre = current;
            if (current.next != null) {
                littleQueue.offer(current.next);
            }
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new MergeKLists().mergeKLists(new ListNode[]{});
        System.out.println();
    }
}
