package dp.Knapsack;

/**
 * @Author: huhan
 * @Date 2020/6/5 7:17 上午
 * @Description 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，
 * 你都可以从 + 或 -中选择一个符号添加在前面。返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * @Verion 1.0
 */
public class TargetSumWays {
    public int findTargetSumWays(int[] nums, int s) {
        if (nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //dp[i][j]表示数组前i个元素使得和为j的方法数
        int[] dp = new int[(sum << 1) + 1];
        dp[nums[0] + sum] += 1;
        dp[-nums[0] + sum] += 1;

        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[(sum << 1) + 1];
            for (int j = -sum; j <= sum; j++) {
                if (j - nums[i] + sum >= 0) {//当前这个数为+
                    next[j + sum] += dp[j - nums[i] + sum];
                }
                if (j + nums[i] + sum <= 2 * sum) {//当前这个数为-
                    next[j + sum] += dp[j + nums[i] + sum];
                }
            }
            dp = next;
        }

        return s > sum ? 0 : dp[s + sum];
    }

    public static void main(String[] args) {
        int targetSumWays = new TargetSumWays().findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1);
        System.out.println(targetSumWays);
    }
}
