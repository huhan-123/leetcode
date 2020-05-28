package two_heaps;

import javax.management.QueryEval;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: huhan
 * @Date 2020/5/26 2:53 下午
 * @Description 数据流中的第K大元素
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * @Verion 1.0
 */
public class KthLargest {
    PriorityQueue<Integer> queue;
    int limit;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.limit = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size()<limit){
            queue.add(val);
        }else if (val>queue.peek()) {
                queue.remove();
                queue.add(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int k=3;
        int[] arr = new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(k, arr);

        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
