package merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: huhan
 * @Date 2020/5/20 3:25 下午
 * @Description 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * @Verion 1.0
 */
//先对区间进行排序，再进行合并
public class MergeIntervals {

    public int[][] mergeIntervals(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return result.toArray(new int[0][]);
        }
        int left, right;
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        for (int i = 0; i < intervals.length; i++) {
            left = intervals[i][0];
            right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                right = Math.max(right, intervals[++i][1]);
            }
            result.add(new int[]{left, right});
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] ints = new MergeIntervals().mergeIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println("");
    }
}
