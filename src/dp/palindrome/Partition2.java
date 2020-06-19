package dp.palindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: huhan
 * @Date 2020/6/7 9:41 下午
 * @Description 分割回文串 II
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的最少分割次数。
 * @Verion 1.0
 */
public class Partition2 {
    boolean[][] dp;
    Map<Integer, Integer> cache = new HashMap<>();

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        dp = generateDpTable(s);
        return dfs(s, 0);
    }

    //left->s.length-1子串的最小切割数
    public int dfs(String s, int left) {
        //如果字串为回文串，直接返回0（不需要切割）
        if (dp[left][s.length()-1]) {
            return 0;
        }

        if (cache.containsKey(left)) {
            return cache.get(left);
        }
        int min = s.length();
        for (int i = left; i < s.length(); i++) {
            if (dp[left][i]) {
                min = Math.min(min, dfs(s, i + 1)+1);
            }
        }
        cache.put(left, min);
        return min;
    }

    //生成dp表
    public boolean[][] generateDpTable(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] sArr = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < s.length(); j++) {
                if (sArr[i] == sArr[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int aab = new Partition2().minCut("bb");
        System.out.println(aab);
    }
}
