package dp.Knapsack;

/**
 * @Author: huhan
 * @Date 2020/6/5 8:55 下午
 * @Description 钢条切割
 * 给定长度为n英寸的钢条，和一个价格表P{1....n}，求切割钢条的方案，使得收益R最大。如果钢条价格足够大，可以完全不用切割。
 * @Verion 1.0
 */
public class CutRod {
    public int findCutRod(int[] p, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], p[j] + dp[i - j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int cutRod = new CutRod().findCutRod(new int[]{0,1, 5, 8, 9, 10, 17, 17}, 7);
        System.out.println(cutRod);
    }
}
