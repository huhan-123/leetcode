package dp.Knapsack;

import java.util.Arrays;

/**
 * @Author: huhan
 * @Date 2020/6/7 7:13 上午
 * @Description 打家劫舍2
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和
 * 最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * @Verion 1.0
 */

/**
 * 思路：环状排列意味着第一个房子和最后一个房子中只能选择一个偷窃，因此可以把环状排列房间问题转化为两个单排排列房间子问题：
 * 1.不偷窃第一个房子
 * 2.不偷窃第二个房子
 */
public class HouseRobber2 {
    public int houseRobber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(help(Arrays.copyOfRange(nums, 1, nums.length)),
                help(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    public int help(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int i = new HouseRobber2().houseRobber(new int[]{0});
        System.out.println();
    }
}
