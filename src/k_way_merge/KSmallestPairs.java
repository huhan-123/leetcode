package k_way_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: huhan
 * @Date 2020/6/3 7:46 上午
 * @Description 查找和最小的K对数字
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 * @Verion 1.0
 */
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int rowLength = nums1.length, colLength = nums2.length;
        if(rowLength==0||colLength==0){
            return new ArrayList<List<Integer>>();
        }
        PriorityQueue<int[]> bigQueue = new PriorityQueue<>((x, y) -> nums1[x[0]] + nums2[x[1]] - nums1[y[0]] - nums2[y[1]]);

        for (int i = 0; i < rowLength; i++) {
            bigQueue.offer(new int[]{i, 0});
        }

        List<List<Integer>> result = new ArrayList<>();
        while (k > 0 && !bigQueue.isEmpty()) {
            int[] pair = bigQueue.poll();
            result.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
            if (pair[1] < colLength - 1) {
                bigQueue.offer(new int[]{pair[0], pair[1] + 1});
            }
            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new KSmallestPairs().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        System.out.println(lists);
    }

}
