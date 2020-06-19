package dp.string;

/**
 * @Author: huhan
 * @Date 2020/6/8 7:29 下午
 * @Description 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * @Verion 1.0
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        //dp[i][j]表示word1前i个字符变成word2前j个字符所需最少操作次数
        int[] help1 = new int[word2.length() + 1];
        int[] help2 = new int[word2.length() + 1];
        int[] dp = help1;
        for (int i = 0; i <= array2.length; i++) {
            help2[i] = i;
        }

        for (int i = 1; i <= array1.length; i++) {
            dp[0] = i;
            for (int j = 1; j <= array2.length; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    dp[j] = help2[j - 1];
                } else {
                    dp[j] = Math.min(dp[j - 1], Math.min(help2[j - 1], help2[j])) + 1;
                }
            }
            help1 = help2;
            help2 = dp;
            dp = help1;
        }
        return help2[word2.length()];
    }

    public static void main(String[] args) {
        int i = new MinDistance().minDistance("horse", "ros");
        System.out.println(i);
    }
}
