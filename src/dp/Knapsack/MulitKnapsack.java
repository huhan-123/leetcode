package dp.Knapsack;

/**
 * @Author: huhan
 * @Date 2020/6/5 4:02 下午
 * @Description 多重背包问题
 * 有N种物品和一个容量为V的背包。第i种物品最多有n[i]件可用，每件费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使这些
 * 物品的费用总和不超过背包容量，且价值总和最大。
 * @Verion 1.0
 */
public class MulitKnapsack {
    public int mulitKnapsack(int N, int V, int[] c, int[] w, int[] n) {
        //dp[i][j]表示背包容积为j时，从前i个物品中选择得到的价值最大值
        int[][] dp = new int[N][V + 1];
        for (int i = V; i >= 0; i--) {
            if (i >= c[0]) {
                dp[0][i] = w[0] * i / c[0];
            } else {
                break;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = V; j >= 0; j--) {
                //这里第i个物品可以选择0次、1次、、、、一直到k/c[i]次
                for (int k = 0; k <= j / c[i] && k <= n[i]; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * c[i]] + k * w[i]);
                }
            }
        }

        return dp[N - 1][V];
    }

    public static void main(String[] args) {
        int i = new MulitKnapsack().mulitKnapsack(4, 5, new int[]{1, 2, 3, 4}, new int[]{2, 4, 4, 5}, new int[]{3, 1, 3, 2});
        System.out.println(i);
    }
}
