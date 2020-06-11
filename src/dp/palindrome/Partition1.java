package dp.palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/6/7 8:34 下午
 * @Description 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * @Verion 1.0
 */
//https://www.cxyxiaowu.com/6890.html
public class Partition {
    //dp[i][j]表示s.substirng(i,j+1)是否为回文串
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        dp = generateDpTable(s);
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), result);
        return result;
    }

    //将s分成0->left和left+1->s.length-1两部分，如果前一部分为回文串，递归分解后一部分，直到将整个字符串分解完，将分解过程中的结果保存下来
    public void dfs(String s, int left, List<String> currentPalindrome, List<List<String>> result) {
        if (left == s.length()) {
            result.add(new ArrayList<>(currentPalindrome));
        }

        for (int i = left; i < s.length(); i++) {
            if (dp[left][i]) {
                currentPalindrome.add(s.substring(left, i + 1));
                dfs(s, i + 1, currentPalindrome, result);
                currentPalindrome.remove(currentPalindrome.size() - 1);
            }
        }
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
        List<List<String>> aab = new Partition().partition("aab");
        System.out.println();
    }
}
