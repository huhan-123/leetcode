package top_k_elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: huhan
 * @Date 2020/6/2 10:08 上午
 * @Description 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * @Verion 1.0
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> littleQueue = new PriorityQueue<>((x, y) -> map.get(x) - map.get(y));

        int count = 0;
        for (Integer element : map.keySet()) {
            if (count < k) {
                littleQueue.offer(element);
            } else {
                if (map.get(element) > map.get(littleQueue.peek())) {
                    littleQueue.offer(element);
                    littleQueue.poll();
                }
            }
            count++;
        }

        int[] result = new int[littleQueue.size()];
        int i = 0;
        while (!littleQueue.isEmpty()) {
            result[i++] = littleQueue.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = new TopKFrequent().topKFrequent(new int[]{1, 1, 12, 2, 3}, 2);
        System.out.println(ints);
    }
}
