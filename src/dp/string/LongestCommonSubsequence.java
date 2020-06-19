package dp.string;

/**
 * @Author: huhan
 * @Date 2020/6/8 1:56 下午
 * @Description 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * @Verion 1.0
 */
public class LongestCommonSubsequence {
    /*public int longestCommonSubsequence(String text1, String text2) {
        char[] array1 = text1.toCharArray();
        char[] array2 = text2.toCharArray();

        return help(array1, array2, 0, 0, 0);
    }

    public int help(char[] array1, char[] array2, int index1, int index2, int result) {
        if (index1 == array1.length || index2 == array2.length) {
            return result;
        }

        if (array1[index1] == array2[index2]) {
            result += 1;
            return help(array1, array2, index1 + 1, index2 + 1, result);
        } else {
            return Math.max(help(array1, array2, index1 + 1, index2, result), help(array1, array2, index1, index2 + 1, result));
        }
    }*/

    public int longestCommonSubsequence(String text1, String text2) {
        char[] array1 = text1.toCharArray();
        char[] array2 = text2.toCharArray();

        //dp[i][j]代表text1中0->i的子串与text2中0->j的子串的最长公共子序列长度
        int[] help1 = new int[array2.length + 1];
        int[] help2 = new int[array2.length + 1];
        int[] dp = help1;
        for (int i = 0; i <= array1.length; i++) {
            help2[0] = 0;
        }

        for (int i = 1; i <= array1.length; i++) {
            dp[0] = 0;
            for (int j = 1; j <= array2.length; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    dp[j] = help2[j - 1] + 1;
                } else {
                    dp[j] = Math.max(help2[j], dp[j - 1]);
                }
            }
            help1 = help2;
            help2 = dp;
            dp = help1;
        }

        return help2[text2.length()];
    }

    public static void main(String[] args) {
        int i = new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }
}
