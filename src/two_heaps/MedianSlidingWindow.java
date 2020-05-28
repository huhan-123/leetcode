package two_heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author: huhan
 * @Date 2020/5/27 9:31 下午
 * @Description 滑动窗口中位数
 * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。
 * 你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * @Verion 1.0
 */

/**
 * 思路：用一个大顶堆存较小部分元素，小顶堆存较大部分元素，要保证大顶堆堆顶元素小于小顶堆堆顶元素，用一个变量balance保存两个
 * 堆的平衡状况，这样中位数就出现在堆顶元素将窗口移除的元素逻辑删除（用一个map存储，key为删除元素，value为删除元素被删除的次
 * 数），而不是从堆中删除，只有当无效元素出现在堆顶时，才将其从堆中删除
 */
public class MedianSlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        //result数组索引
        int index = 0;
        boolean isOdd = ((k & 1) == 1);
        //left,right分别代表窗口左右两个指针，banlance表示大顶堆有效数据个数减小顶堆有效数据个数
        int left = 0, right = 0, balance;
        //存储移除窗口的元素，key为移除窗口的元素，value为移出该元素的个数
        HashMap<Double, Integer> removed = new HashMap<>();
        PriorityQueue<Double> bigQueue = new PriorityQueue<>((x, y) -> (int) (y - x));
        PriorityQueue<Double> littleQueue = new PriorityQueue<>();

        //先放k个元素到堆中
        for (; right < k; right++) {
            if (bigQueue.size() == 0) {
                bigQueue.offer((double) (nums[right]));
                continue;
            }
            if ((double) nums[right] <= bigQueue.peek()) {
                bigQueue.offer((double) nums[right]);
            } else {
                littleQueue.offer((double) nums[right]);
            }

            if (bigQueue.size() - littleQueue.size() > 1) {
                littleQueue.offer(bigQueue.poll());
            } else if (littleQueue.size() - bigQueue.size() > 1) {
                bigQueue.offer(littleQueue.poll());
            }
        }
        if (isOdd) {
            if (bigQueue.size() > littleQueue.size()) {
                result[index++] = bigQueue.peek() * 1.0;
                balance = 1;
            } else {
                result[index++] = littleQueue.peek() * 1.0;
                balance = -1;
            }
        } else {
            result[index++] = (bigQueue.peek() + littleQueue.peek()) / (2 * 1.0);
            balance = 0;
        }

        while (right < nums.length) {
            if (!bigQueue.isEmpty() && (double) nums[right] <= bigQueue.peek()) {
                bigQueue.offer((double) (nums[right]));
                balance++;
            } else {
                littleQueue.offer((double) nums[right]);
                balance--;
            }

            //然后在把左边的元素从堆中逻辑删除
            removed.put((double) nums[left], removed.getOrDefault(nums[left], 0) + 1);
            if (!bigQueue.isEmpty() && (double) nums[left] <= bigQueue.peek()) {
                balance--;
            } else {
                balance++;
            }

            //平衡堆
            if (balance > 1) {
                littleQueue.offer(bigQueue.poll());
                balance -= 2;
            } else if (balance < -1) {
                bigQueue.offer(littleQueue.poll());
                balance += 2;
            }

            //将堆顶的无效元素从堆中移除
            while (removed.getOrDefault(bigQueue.peek(), 0) != 0 || removed.getOrDefault(littleQueue.peek(), 0) != 0) {
                if (removed.getOrDefault(bigQueue.peek(), 0) != 0) {
                    removed.put(bigQueue.peek(), removed.get(bigQueue.poll()) - 1);
                } else {
                    removed.put(littleQueue.peek(), removed.get(littleQueue.poll()) - 1);
                }
            }

            //将中位数加入到result
            if (isOdd) {
                if (balance == 1) {
                    result[index++] = bigQueue.peek() * 1.0;
                } else {
                    result[index++] = littleQueue.peek() * 1.0;
                }
            } else {
                result[index++] = (bigQueue.peek() + littleQueue.peek()) / (2 * 1.0);
            }
            right++;
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        double[] doubles = new MedianSlidingWindow().medianSlidingWindow(new int[]{7, 9, 3, 8, 0, 2, 4, 8, 3, 9}, 1);
        System.out.println();
    }
}
