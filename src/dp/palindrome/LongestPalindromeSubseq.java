package dp.palindrome;

/**
 * @Author: huhan
 * @Date 2020/6/7 11:21 上午
 * @Description 最长回文子序列
 * 给定一个字符串s，找到其中最长的回文子序列，并返回该序列的长度。可以假设s的最大长度为1000。
 * @Verion 1.0
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }

        char[] sArr = s.toCharArray();
        int[] help1 = new int[s.length()];
        int[] help2 = new int[s.length()];
        int dp[] = help1;

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i == 1) {
                    if (sArr[i] == sArr[j]) {
                        dp[j] = 2;
                    } else {
                        dp[j] = 1;
                    }
                } else {
                    if (sArr[i] == sArr[j]) {
                        dp[j] = help2[j - 1] + 2;
                    } else {
                        dp[j] = Math.max(help2[j], dp[j - 1]);
                    }
                }
            }
            help1 = help2;
            help2 = dp;
            dp = help1;
        }

        return help2[s.length() - 1];
    }

    public static void main(String[] args) {
        int bbbab = new LongestPalindromeSubseq().longestPalindromeSubseq("ababa");
        System.out.println(bbbab);
    }
}
