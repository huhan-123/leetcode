package two_points.collision_pointer;

import java.util.HashMap;

/**
 * @Author: huhan
 * @Date 2020/5/17 9:37 上午
 * @Description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * @Verion 1.0
 */
//本题可以先对数组排序，然后在通过对撞指针找到两个索引。但是下面实现的算法更快，因此这里采用了下面的算法
class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int residual = target - nums[i];
            if (map.containsKey(residual) && map.get(residual) != i) {
                return new int[]{i, map.get(residual)};
            }
        }
        return null;*/

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int residual = target - nums[i];
            if (map.containsKey(residual)) {
                return new int[]{ map.get(residual),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] ints = new Solution().twoSum(new int[]{2, 3, 4}, 6);
        for (int i = 0; i < ints.length; i++) {
            int anInt = ints[i];
            System.out.println(anInt);
        }
    }
}