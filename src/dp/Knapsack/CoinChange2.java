package dp.Knapsack;

/**
 * @Author: huhan
 * @Date 2020/6/6 10:12 上午
 * @Description 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * @Verion 1.0
 */
public class CoinChange2 {
    //方法一：
    /*public int change(int amount, int[] coins) {
        if (coins.length == 0) {
            return amount == coins.length ? 1 : 0;
        }
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                for (int k = j / coins[i]; k >= 0; k--) {
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }*/

    //方法二
    //https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-ii-by-leetcode/
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int i = new CoinChange2().change(3, new int[]{2});
        System.out.println(i);
    }
}
