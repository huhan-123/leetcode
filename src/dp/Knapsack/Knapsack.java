package dp.Knapsack;

/**
 * @Author: huhan
 * @Date 2020/6/5 9:38 上午
 * @Description 0-1 背包问题
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。其中第 i 个物品的重量为 wt[i]，
 * 价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 * @Verion 1.0
 */
public class Knapsack {
    public int knapsack(int w, int n, int[] weight, int[] value) {
        int[] dp = new int[w + 1];
        for (int i = 0; i < n; i++) {
            dp[0] = 0;
        }
        for (int i = w; i >= 0; i--) {
            if (i >= weight[0]) {
                dp[i] = value[0];
            } else {
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = w; j >=1; j--) {
                if (j>=weight[i]){
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        return dp[w];
    }

    public static void main(String[] args) {
        int knapsack = new Knapsack().knapsack(4, 3, new int[]{2, 1, 3}, new int[]{4, 2, 3});
        System.out.println(knapsack);
    }
}
