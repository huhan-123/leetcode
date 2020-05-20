package two_points.collision_pointer;

import java.util.Arrays;

/**
 * @Author: huhan
 * @Date 2020/5/19 2:50 下午
 * @Description 三数之和变种
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * @Verion 1.0
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int left, mid, right, gap = Integer.MAX_VALUE, residual, twoSum;
        Arrays.sort(nums);

        for (left = 0; left < nums.length - 2; left++) {
            mid = left + 1;
            right = nums.length - 1;

            residual = target - nums[left];
            while (mid < right) {
                twoSum = nums[mid] + nums[right];
                if (twoSum == residual) {
                    return target;
                } else if (twoSum > residual) {
                    gap = Math.abs(gap) < Math.abs(residual - twoSum) ? gap : residual - twoSum;
                    right--;
                } else {
                    gap = Math.abs(gap) < Math.abs(residual - twoSum) ? gap : residual - twoSum;
                    mid++;
                }
            }
        }

        return target - gap;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }
}
