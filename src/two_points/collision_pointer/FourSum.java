package two_points.collision_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/19 9:56 下午
 * @Description 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在
 * 四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * @Verion 1.0
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int left, mid1, mid2, right;
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (left = 0;left < nums.length - 3; left++) {
            if (left > 0 && nums[left - 1] == nums[left]) {
                continue;
            }
            for (mid1 = left + 1; mid1 < nums.length - 2; mid1++) {
                if (mid1 > left + 1 && nums[mid1] == nums[mid1 - 1]) {
                    continue;
                }
                mid2 = mid1 + 1;
                right = nums.length - 1;
                int residual = target - nums[left] - nums[mid1];
                while (mid2 < right) {
                    if (nums[mid2] + nums[right] == residual) {
                        result.add(Arrays.asList(nums[left], nums[mid1], nums[mid2], nums[right]));
                        mid2++;
                        right--;
                        while (mid2 < right && nums[mid2] == nums[mid2 - 1]) {
                            mid2++;
                        }
                        while (mid2 < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (nums[mid2] + nums[right] > residual) {
                        right--;
                    } else {
                        mid2++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
    }
}
