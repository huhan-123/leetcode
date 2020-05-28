package two_heaps;

import java.util.PriorityQueue;

/**
 * @Author: huhan
 * @Date 2020/5/28 4:41 下午
 * @Description 最低加油次数
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 * @Verion 1.0
 */

/**
 * 思路：每路过一个加油站，不用考虑是否加油，而是将每个加油站的油量用一个堆存起来，如果当前油量不足以到达下一个加油站，
 * 则从堆中选择一个最大油量进行加油，如果当前无法到达下一个加油站，并且堆为空，则说明无法到达目的地
 */
public class MinRefuelStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int result = 0, i = 0;
        PriorityQueue<Integer> bigQueue = new PriorityQueue<>((x, y) -> y - x);

        for (; i < stations.length && startFuel < target; i++) {
            if (startFuel >= stations[i][0]) {//可以到达下一加油站
                bigQueue.offer(stations[i][1]);
            } else {//不能达到下一站，需要加油（可能加好几次）
                while (!bigQueue.isEmpty() && startFuel < stations[i][0]) {
                    startFuel += bigQueue.poll();
                    result++;
                }

                if (bigQueue.isEmpty() && startFuel < stations[i][0]) {
                 } else {
                    bigQueue.offer(stations[i][1]);
                }
            }
        }

        if (i == stations.length) {    //加油站完了，但是没有到达目的地
            while (!bigQueue.isEmpty() && startFuel < target) {
                startFuel += bigQueue.poll();
                result++;
            }
            if (startFuel < target) {
                return -1;
            } else {
                return result;
            }
        } else { //到达目的地
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MinRefuelStops().minRefuelStops(100, 50, new int[][]{{25, 25}, {50, 50}}));
    }
}
