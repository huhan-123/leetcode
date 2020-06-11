package dp;

/**
 * @Author: huhan
 * @Date 2020/6/5 3:10 下午
 * @Description 完全背包问题
 * 有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使
 * 这些物品的费用总和不超过背包容量，且价值总和最大,最大值是多少。
 * @Verion 1.0
 */
public class CompleteKnapsack {
    public int completeKnapsack(int n, int v, int[] c, int[] w) {
        //dp[i][j]表示背包容积为j时，从前i个物品中选择得到的价值最大值
        int[][] dp = new int[n][v + 1];
        for (int i = v; i >= 0; i--) {
            if (i >= c[0]) {
                dp[0][i] = w[0];
            } else {
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = v; j >= 0; j--) {
                //这里可以第i个物品可以选择0次、1次、、、、一直到k/c[i]次
                for (int k = 0; k <= j / c[i]; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * c[i]] + k * w[i]);
                }
            }
        }

        return dp[n - 1][v];
    }

    public static void main(String[] args) {
        int i = new CompleteKnapsack().completeKnapsack(4, 5, new int[]{1, 2, 3, 4}, new int[]{2, 4, 4, 5});
        System.out.println(i);
    }
}
