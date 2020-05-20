package two_points.collision_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/17 12:18 下午
 * @Description 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组(答案中不可以包含重复的三元组)。
 * @Verion 1.0
 */
//两个重点：1.三元组中选择第一个元素，将问题转化为其它两个元素和的问题 2.去重
//https://hk029.gitbooks.io/leetbook/%E6%95%B0%E7%BB%84/015.%203Sum/015.%203Sum.html
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int left, mid, right;
        Arrays.sort(nums);
        for (left= 0; left < nums.length - 2&& nums[left] <= 0; left++) {
            mid = left + 1;
            right = nums.length - 1;

            //跳过left重复匹配
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }
            while (nums[left] <= 0 && mid < right) {
                int residual = -nums[left];
                if (nums[mid] + nums[right] == residual) {
                    result.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    mid++;
                    right--;
                    //跳过mid和right的重复匹配
                    while (mid < right && nums[mid] == nums[mid - 1]) {
                        mid++;
                    }
                    while (mid < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[mid] + nums[right] < residual) {
                    mid++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{0,0,0}));
        int[] ints = {-1, 0, 1, 2, -1, -4};
    }
}
