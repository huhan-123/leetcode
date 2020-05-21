package merge_Intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/21 7:46 上午
 * @Description 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * @Verion 1.0
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            result.add(newInterval);
            return result.toArray(new int[1][]);
        }
        int left = newInterval[0], right = newInterval[1];
        //遍历列表
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > right) {  //当前区间在所给区间右侧
                result.add(new int[]{left, right});
                while (i < intervals.length) {
                    result.add(intervals[i++]);
                }
            } else if (intervals[i][1] < left) {    //当前区间在所给区间左侧
                result.add(intervals[i]);
                if (i + 1 == intervals.length) {
                    result.add(new int[]{left, right});
                }
            } else {    //当前区间和所给区间有重叠区域
                //合并两个有重叠的区间
                int[] mergedInterval = merge(intervals[i], left, right);
                left = mergedInterval[0];
                right = mergedInterval[1];
                if (i + 1 == intervals.length) {
                    result.add(new int[]{left, right});
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public int[] merge(int[] A, int left, int right) {
        if (A[0] < left) {
            if (A[1] < right) {
                return new int[]{A[0], right};
            } else {
                return A;
            }
        } else {
            if (A[1] > right) {
                return new int[]{left, A[1]};
            } else {
                return new int[]{left, right};
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new InsertInterval().insert(new int[][]{{1, 5}}, new int[]{2, 3}));
    }
}
