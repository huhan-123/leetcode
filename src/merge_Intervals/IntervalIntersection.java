package merge_Intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/20 9:44 下午
 * @Description 区间列表的交集
 * 给定两个由一些闭区间组成的列表，每个区间列表都是成对不相交的，并且已经排序。
 * @Verion 1.0
 */
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][0]<=B[j][0]){
                if(A[i][1]<B[j][0]){
                    i++;
                }else if (A[i][1]==B[j][0]){
                    result.add(new int[]{A[i][1], B[j][0]});
                    i++;
                }else if (A[i][1]<B[j][1]){
                    result.add(new int[]{B[j][0],A[i][1]});
                    i++;
                }else {
                    result.add(new int[]{B[j][0], B[j][1]});
                    j++;
                }
            }else {
                if (B[j][1]<A[i][0]){
                    j++;
                }else if (B[j][1]==A[i][0]){
                    result.add(new int[]{B[j][1], A[i][0]});
                    j++;
                }else if (B[j][1]<A[i][1]){
                    result.add(new int[]{A[i][0], B[j][1]});
                    j++;
                }else {
                    result.add(new int[]{A[i][0], A[i][1]});
                    i++;
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] ints = new IntervalIntersection().intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        System.out.println("");
    }
}
