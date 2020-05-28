package two_heaps;

import java.util.PriorityQueue;

/**
 * @Author: huhan
 * @Date 2020/5/26 5:15 下午
 * @Description 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * @Verion 1.0
 */

/**
 * 思路：用一个大顶堆存储左半部分，小顶堆存储右半部分，两个堆中元素个数之差不能大于二，中位数就出现在某一个堆的堆顶或者两个堆顶元素平均值。
 */
public class MedianFinder {
    PriorityQueue<Integer> bigQueue;
    PriorityQueue<Integer> littleQueue;

    public MedianFinder() {
        this.bigQueue = new PriorityQueue<>((x, y) -> y - x);
        this.littleQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //两个堆都为空，先往大顶堆添加
        if (bigQueue.size()==0){
            bigQueue.offer(num);
            return;
        }

        if (num<bigQueue.peek()){
            bigQueue.offer(num);
        }else {
            littleQueue.offer(num);
        }

        if (bigQueue.size() - littleQueue.size() > 1) {
            littleQueue.offer(bigQueue.poll());
        }else if (littleQueue.size()-bigQueue.size()>1){
            bigQueue.offer(littleQueue.poll());
        }
    }

    public double findMedian() {
        if (bigQueue.size()==littleQueue.size()){
            return (bigQueue.peek()+littleQueue.peek())/(2*1.0);
        } else if (bigQueue.size() > littleQueue.size()) {
            return bigQueue.peek();
        }else {
            return littleQueue.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
