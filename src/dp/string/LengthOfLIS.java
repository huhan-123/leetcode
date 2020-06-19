package dp.string;

/**
 * @Author: huhan
 * @Date 2020/6/8 3:35 下午
 * @Description 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * @Verion 1.0
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        //dp[i]表示以nums[i]结尾的子序列最大长度
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] <= nums[j]) {
                    continue;
                }
                dp[i] = Math.max(dp[i],dp[j]+1);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new LengthOfLIS().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);
    }
}
