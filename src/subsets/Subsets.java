package subsets;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;

/**
 * @Author: huhan
 * @Date 2020/5/30 7:16 上午
 * @Description 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * @Verion 1.0
 */

public class Subsets {

    /**
     * 给一组数字：{1,2,3}
     * 1.从空集开始：{{}}
     * 2.把第一个数（1）加入到之前的集合 ：{{},{1}}
     * 3.把第二个数（2）加入到之前的集合：{{},{1},{2},{1,2}}
     * 4.把第三个数（3）加入到之前的集合:{{},{1},{2},{1,2},{3},{1,3},{2,3},{1,2,3}}
     */
    /*public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> newSet = new ArrayList<>(result.get(j));
                newSet.add(nums[i]);
                result.add(newSet);
            }
        }
        return result;
    }*/

    /**
     * 先找出含有0个元素的子集，再在上个子集的基础上找出含有1个元素的子集，再在上个子集的基础上找出含有2个元素的子集，以此类推
     */
    /*public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtracks(nums, 0, new LinkedList<>(), result);
        return result;
    }

    public void backtracks(int[] nums, int start, LinkedList<Integer> track, List<List<Integer>> result) {
        result.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtracks(nums,i+1,track,result);
            track.removeLast();
        }
    }*/

    /**
     * 递归遍历每个元素，每一个元素有两种情况：1.选该元素  2.不选该元素。用一个变量存储当前元素的索引，另一个变量存储
     * 当前选取的所有元素，如果遍历完所有的元素，就将选取的元素加入到结果集
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtracks(nums, 0, new LinkedList<>(), result);
        return result;
    }

    //递归遍历数组，每到一个元素就有两种情况：1.选该元素 2.不选该元素
    public void backtracks(int[] nums, int current, LinkedList<Integer> track, List<List<Integer>> result) {
        //已经遍历完所有元素
        if (current == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        //不选当前元素
        backtracks(nums, current + 1, track, result);
        //选当前元素
        track.add(nums[current]);
        backtracks(nums, current + 1, track, result);
        //撤销选取当前元素（回溯）
        track.removeLast();
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new Subsets().subsets(new int[]{1, 2, 3});
        System.out.println();
    }
}
