package subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/30 8:17 下午
 * @Description 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * @Verion 1.0
 */
public class Permutations {
    public List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(nums, new LinkedList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!track.contains(nums[i])) {
                track.add(nums[i]);
                backtrack(nums, track, result);
                track.removeLast();
            }
        }
    }
}
