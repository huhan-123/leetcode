package dp;

/**
 * @Author: huhan
 * @Date 2020/6/4 7:44 下午
 * @Description 子集和的最小差问题
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute
 * difference between their sums is minimum.
 * If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have
 * n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 * <p>
 * Example:
 * Input:  arr[] = {1, 6, 11, 5}
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * Subset2 = {11}, sum of Subset2 = 11
 * @Verion 1.0
 */
public class MinimumDifferenceOfSubsets {
    //递归
    /*public int findMinRec(int[] nums) {
        return help(nums, nums.length-1, 0, 0);
    }

    //以index结尾的子数组的子集和的最小差,当前两个集合的和分别为s1、s2
    public int help(int[] nums, int index, int s1, int s2) {
        if (index == -1) {
            return Math.abs(s1 - s2);
        }

        return Math.min(help(nums, index - 1, s1 + nums[index], s2), help(nums, index - 1, s1, s2 + nums[index]));
    }*/


    //动态规划
    public int findMinRec(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        int n = nums.length;
        // 状态转移方程
        //dp[i][j]表示数组前i个元素最接近j的和
        int[][] dp = new int[n][sum / 2 ];

        // 首先检查 0 号元素是否可以存入背包
        for (int i = 0; i < sum / 2; i++ ) {
            dp[0][i] = (i >= nums[0]) ? nums[0] : 0;
        }

        // 然后再动态规划处理
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < sum / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                // 若剩余空间可以存入当前的array[i]
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }

        return sum - 2 * dp[n - 1][sum / 2-1];
    }

    public static void main(String[] args) {
        int minRec = new MinimumDifferenceOfSubsets().findMinRec(new int[]{10, 20, 15, 5, 25});
        System.out.println(minRec);
    }
}
