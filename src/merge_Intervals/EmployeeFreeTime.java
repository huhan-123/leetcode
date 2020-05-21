package merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/21 9:25 上午
 * @Description 职员空闲时间
 * 我们为员工提供了一份时间表，该时间表代表了每个员工的工作时间。
 * 每个员工都有一个不重叠的时间间隔列表，这些时间间隔是按排序顺序排列的。
 * 返回有限间隔的列表，这些间隔代表所有员工的共同的正长度的空闲时间，也按排序顺序。
 * @Verion 1.0
 */
//先把空闲时间根据开始时间排序，然后合并区间，如果不能合并则出现空闲时间
public class EmployeeFreeTime {
    public int[][] employeeFreeTime(int [][] schedules){
        List<int[]> result = new ArrayList<>();
        if (schedules == null || schedules.length == 0) {
            result.add(new int[]{0, 24});
            return result.toArray(new int[1][]);
        }

        Arrays.sort(schedules,(x,y)->{
            if (x[0]==y[0]){
                return x[1] - y[1];
            }else {
                return x[0] - y[0];
            }
        });
        int left=schedules[0][0],right=schedules[0][1];
        for (int i = 1;i<schedules.length;i++){
            if (schedules[i][0] > right) {
                result.add(new int[]{right, schedules[i][0]});
                left = schedules[i][0];
                right = schedules[i][1];
            }else {
                right = schedules[i][1];
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] ints = new EmployeeFreeTime().employeeFreeTime(new int[][]{{1, 3}, {6, 7}, {2, 4}, {2, 5},{9,12}});
        System.out.println("");
    }
}
