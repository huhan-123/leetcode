package dp.Knapsack;

import java.util.Arrays;

/**
 * @Author: huhan
 * @Date 2020/6/5 9:39 下午
 * @Description 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * @Verion 1.0
 */
public class CoinChange {
    //方法一：
    /*public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        //dp[j]表示从硬币中选择得到j金额的最小硬币数
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[i] = i / coins[0];
            } else {
                dp[i] = -1;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = amount; j >= 0; j--) {
                for (int k = 0; k <= j / coins[i]; k++) {
                    if (dp[j - k * coins[i]] != -1) {
                        if (dp[j] == -1) {
                            dp[j] = dp[j - k * coins[i]] + k;
                        } else {
                            dp[j] = Math.min(dp[j], dp[j - k * coins[i]] + k);
                        }
                    }
                }
            }
        }

        return dp[amount];
    }*/

    //方法二：dp[i]表示组成金额i所需最少的硬币数量。dp[i]=min{dp[i-coins[0]],dp[i-coins[1]],,,,,}+1
    /*public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //次数不可能超过amount
            dp[i] = amount + 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //当前金额大于等于coins[j]的值
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }*/

    //方法三：深度搜索+剪枝(性能最优)
    int result = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public void dfs(int[] coins, int amount, int currentIndex, int currentCount) {
        //所有硬币已经遍历过了
        if (currentIndex == -1) {
            return;
        }

        //当前硬币可能选0-k个（k从大到小遍历配合剪枝可有效减少遍历次数），更新其中最少硬币数
        for (int k = amount / coins[currentIndex]; k >= 0; k--) {
            int newCount = currentCount+k;
            int newAmount = amount - k * coins[currentIndex];
            if(newAmount==0){
                result=Math.min(result,newCount);
                break;//剪枝1
            }
            if(newCount+1>=result){
                break; //剪枝2
            }
            dfs(coins, newAmount, currentIndex - 1, newCount);
        }
    }

    public static void main(String[] args) {
        int i = new CoinChange().coinChange(new int[]{186, 419, 83, 408}, 6249);
        System.out.println(i);
    }
}
