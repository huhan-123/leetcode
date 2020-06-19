package dp.palindrome;

/**
 * @Author: huhan
 * @Date 2020/6/7 10:03 上午
 * @Description 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @Verion 1.0
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        char[] sArr = s.toCharArray();
        int maxLeft = 0, maxRight = 0;
        //dp[i][j]表示i->j的字串是否为回文串
        boolean[] dp = new boolean[s.length()];

        //当i==j，即只有一个字符时为回文串
        for (int i = 0; i < s.length(); i++) {
            dp[i] = true;
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            dp[i]=true;
            for (int j = s.length() - 1; j > i; j--) {
                if (sArr[i] != sArr[j]) {
                    dp[j] = false;
                } else {
                    if (j - i <= 2 || dp[j - 1]) {
                        dp[j] = true;
                        if (j - i > maxRight - maxLeft) {
                            maxLeft = i;
                            maxRight = j;
                        }
                    } else {
                        dp[j] = false;
                    }
                }
            }
        }

        return s.substring(maxLeft, maxRight + 1);
    }

    public static void main(String[] args) {
        String babad = new LongestPalindrome().longestPalindrome("abacab");
        System.out.println(babad);
    }
}
