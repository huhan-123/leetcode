package dp.string;

/**
 * @Author: huhan
 * @Date 2020/6/8 8:41 下午
 * @Description 交错字符串
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * @Verion 1.0
 */
public class Interleave {
    //方法一：
    /*public boolean isInterleave(String s1, String s2, String s3) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        char[] array3 = s3.toCharArray();
//        int i = array1.length - 1, j = array2.length - 1, k = array3.length - 1;
        boolean[][][] dp = new boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        dp[0][0][0] = true;
        for (int i=1;i<=array3.length;i++){
            dp[0][0][i]=false;
        }
        for (int i = 1; i <= array1.length; i++) {
            for (int k = 1; k <= array3.length; k++) {
                dp[i][0][k] = array1[i-1] == array3[k-1] && dp[i - 1][0][k - 1];
            }
        }
        for (int i = 1; i <= array2.length; i++) {
            for (int k = 1; k <= array3.length; k++) {
                dp[0][i][k] = array2[i-1] == array3[k-1] && dp[0][i - 1][k - 1];
            }
        }

        for (int i = 1; i <= array1.length; i++) {
            for (int j = 1; j <= array2.length; j++) {
                for (int k = 1; k <= array3.length; k++) {
                    if (array1[i-1] != array3[k-1] && array2[j-1] != array3[k-1]) {
                        dp[i][j][k] = false;
                    } else if (array1[i-1] == array3[k-1] && array2[j-1] == array3[k-1]) {
                        dp[i][j][k] = dp[i - 1][j][k - 1] || dp[i][j - 1][k - 1];
                    } else if (array1[i-1] == array3[k-1]) {
                        dp[i][j][k] = dp[i - 1][j][k - 1];
                    } else {
                        dp[i][j][k] = dp[i][j - 1][k - 1];
                    }
                }
            }
        }

        return dp[array1.length][array2.length][array3.length];
    }*/


    //方法二：从三个字符串的最后一个字符开始匹配，如果匹配到最后都没有了字符，则返回true，否则返回false
    /*public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        char[] array3 = s3.toCharArray();
        return help(array1, array2, array3, array1.length, array2.length, array3.length);
    }

    public boolean help(char[] array1, char[] array2, char[] array3, int i, int j, int k) {
        if (i == 0 && j == 0) {
            if (k == 0) {
                return true;
            } else {
                return false;
            }
        }

        if (i == 0) {
            while (j > 0) {
                if (array2[j - 1] == array3[k - 1]) {
                    j--;
                    k--;
                } else {
                    return false;
                }
            }
            return true;
        } else if (j == 0) {
            while (i > 0) {
                if (array1[i - 1] == array3[k - 1]) {
                    i--;
                    k--;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            if (array1[i - 1] == array3[k - 1] && array2[j - 1] == array3[k - 1]) {
                return help(array1, array2, array3, i - 1, j, k - 1) || help(array1, array2, array3, i, j - 1, k - 1);
            } else if (array1[i - 1] == array3[k - 1]) {
                return help(array1, array2, array3, i - 1, j, k - 1);
            } else if (array2[j - 1] == array3[k - 1]) {
                return help(array1, array2, array3, i, j - 1, k - 1);
            } else {
                return false;
            }
        }
    }*/

    //方法三：求出所有s1,s2组合的字符串，判断其中是否有s3
    /*public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        return help(array1, array2, s3, new StringBuilder(), 0, 0);
    }

    public boolean help(char[] array1, char[] array2, String s3, StringBuilder currentStr, int index1, int index2) {
        if (index1 == array1.length && index2 == array2.length) {
            return currentStr.toString().equals(s3);
        }
        boolean result = false;
        if (index1 < array1.length) {
            currentStr.append(array1[index1]);
            result = result || help(array1, array2, s3, currentStr, index1 + 1, index2);
            currentStr.deleteCharAt(currentStr.length() - 1);
        }
        if (result == true) {//剪枝
            return result;
        }
        if (index2 < array2.length) {
            currentStr.append(array2[index2]);
            result = result || help(array1, array2, s3, currentStr, index1, index2+1);
            currentStr.deleteCharAt(currentStr.length() - 1);
        }
        return result;
    }*/

    //方法四：
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        char[] array3 = s3.toCharArray();

        //dp[i][j]表示 s1[ 0, i ) 和 s2 [ 0, j ） 组合后能否构成 s3 [ 0, i + j )
        boolean[][] dp = new boolean[array1.length + 1][array2.length + 1];
        for (int i = 0; i <= array1.length; i++) {
            for (int j = 0; j <= array2.length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = array2[j - 1] == array3[j - 1] && dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = array1[i - 1] == array3[i - 1] && dp[i - 1][j];
                } else {
                    dp[i][j] = (array1[i - 1] == array3[i + j - 1] && dp[i - 1][j])
                            || (array2[j - 1] == array3[i + j - 1] && dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        boolean interleave = new Interleave().isInterleave("aabcc", "dbbca", "aadbbcacac");
        System.out.println(interleave);
    }
}
