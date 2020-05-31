package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/30 8:24 上午
 * @Description SubSets2
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * @Verion 1.0
 */
//采用回溯法：先找到只有0个元素的子集，在上个子集的基础上再找只有一个元素的子集，在上个子集的基础上再找两个元素的子集，依次类推
public class SubsetsWithDup {
    /*public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            int count = map.getOrDefault(nums[i], 0);
            if (count == 0) {
                for (int j = 0; j < size; j++) {
                    ArrayList<Integer> newSet = new ArrayList<>(result.get(j));
                    newSet.add(nums[i]);
                    result.add(newSet);
                }
            } else {
                //过滤掉出现nums[i]个数小于count的子集
                for (int j = 0; j < size; j++) {
                    List<Integer> subset = result.get(j);
                    if (findCount(subset, nums[i]) == count) {
                        ArrayList<Integer> newSet = new ArrayList<>(subset);
                        newSet.add(nums[i]);
                        result.add(newSet);
                    }
                }
            }
            map.put(nums[i], count + 1);
        }
        return result;
    }

    public int findCount(List<Integer> list, int i) {
        int count = 0;
        for (Integer num : list) {
            if (num == i) {
                count++;
            }
        }
        return count;
    }*/

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        backtracks(nums, 0, new LinkedList<>(), result);
        return result;
    }

    public void backtracks(int[] nums, int start, LinkedList<Integer> track, List<List<Integer>> result) {
        result.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            backtracks(nums, i + 1, track, result);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new SubsetsWithDup().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println();
    }
}
