package dp;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: huhan
 * @Date 2020/6/4 4:11 下午
 * @Description 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @Verion 1.0
 */
public class PartitionTwoSubsets {
    //解法一：动态规划
    /*public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        sum=sum>>1;
        boolean dp[][] = new boolean[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        //第一个数只能让容积为它自己的背包装满
        dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (i == nums.length - 1 && j != sum) {
                    continue;
                }
                if (j - nums[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][sum];
    }*/

    //解法二：回溯法
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        sum /= 2;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > sum) {
            return false;
        }
        return help(nums, sum, nums.length - 1);
    }

    //判断以index结尾的子数组能否组合出target
    public boolean help(int[] nums, int target, int index) {
        if (index == -1) {
            return target == 0;
        }

        if (nums[index] == target || target - nums[index] >= nums[0]) {
            return help(nums, target - nums[index], index - 1) || help(nums, target, index - 1);
        } else {
            return help(nums, target, index - 1);
        }
    }

    public static void main(String[] args) {
        boolean b = new PartitionTwoSubsets().canPartition(new int[]{99, 2, 3, 98});
        System.out.println(b);
        ArrayDeque<Integer> objects = new ArrayDeque<Integer>();
        Integer pop = objects.pop();
    }
}
