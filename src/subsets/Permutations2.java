package subsets;

import java.util.*;

/**
 * @Author: huhan
 * @Date 2020/5/30 9:28 下午
 * @Description Permutations
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @Verion 1.0
 */
//在上一个全排列的基础上，加了一个map用于存储剩余数字的次数，判断一个数字是否可以加入到track中，其次加了一个剪枝条件：nums[i] != nums[i - 1]
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        backtrack(nums, new LinkedList<>(), map, result);
        return result;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, Map<Integer, Integer> map, List<List<Integer>> result) {
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            Integer residual = map.getOrDefault(nums[i], 0);
            if ((i == 0 || nums[i] != nums[i - 1]) && residual != 0) {
                track.add(nums[i]);
                map.put(nums[i], residual - 1);
                backtrack(nums, track, map, result);
                map.put(nums[i], residual);
                track.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Permutations2().permuteUnique(new int[]{3,3,0,3});
        System.out.println();
    }
}
