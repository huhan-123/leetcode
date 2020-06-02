package top_k_elements;

import java.util.PriorityQueue;

/**
 * @Author: huhan
 * @Date 2020/6/2 9:16 上午
 * @Description 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的
 * @Verion 1.0
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> bigQueue = new PriorityQueue<>((x, y) -> distance(y) - distance(x));
        for (int i = 0; i < points.length; i++) {
            if (i < K) {
                bigQueue.offer(points[i]);
            } else {
                if (distance(points[i]) < distance(bigQueue.peek())) {
                    bigQueue.offer(points[i]);
                    bigQueue.poll();
                }
            }
        }

        int[][] result = new int[bigQueue.size()][2];
        int i = 0;
        while (!bigQueue.isEmpty()) {
            result[i++] = bigQueue.poll();
        }

        return result;
    }

    public int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
