import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/30 11:59 上午
 * @Description N皇后
 * @Verion 1.0
 */

/**
 * https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/hui-su-suan-fa-xiang-jie-xiu-ding-ban
 * 解决一个回溯问题，实际上就是一个决策树的遍历过程。写backtrack函数时，需要维护走过的「路径」和当前的「选择列表」，
 * 当触发「结束条件」时，将「路径」记入结果集
 * 本题思路：每层选择一个点作为皇后，逐层向下选择，直到选到最后一层，然后将该结果加入到result，然后回溯
 * 回溯模版代码：
 * result = []
 * def backtrack(路径, 选择列表):
 * if 满足结束条件:
 * result.add(路径)
 * return
 * <p>
 * for 选择 in 选择列表:
 * 做选择
 * backtrack(路径, 选择列表)
 * 撤销选择
 */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<char[][]> result = new ArrayList<>(n);
//        String s = Stream.generate(() -> String.valueOf('.')).limit(n).collect(Collectors.joining());
        char[][] track = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                track[i][j] = '.';
            }
        }
        int row = 0;
        backtrack(n, track, row, result);
        return convert(result);
    }

    public void backtrack(int n, char[][] track, int row, List<char[][]> result) {
        if (row == n) {
            result.add(arrayCopyOf(track));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isVaild(row, col, track)) {
                track[row][col] = 'Q';
                backtrack(n, track, row + 1, result);
                track[row][col] = '.';
            }
        }

    }

    private boolean isVaild(int row, int col, char[][] track) {
        if (row != 0) {
            //不能在同一列
            for (int i = row - 1; i >= 0; i--) {
                if (track[i][col] == 'Q') {
                    return false;
                }
            }
            //左上方不能有皇后
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (track[i][j] == 'Q') {
                    return false;
                }
            }
            //右上方不能有皇后
            for (int i = row - 1, j = col + 1; i >= 0 && j < track.length; i--, j++) {
                if (track[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    public char[][] arrayCopyOf(char[][] original) {
        int row = original.length;
        int col = original[0].length;
        char[][] current = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                current[i][j] = original[i][j];
            }
        }
        return current;
    }

    //将结果转化为题目所需的类型
    public List<List<String>> convert(List<char[][]> original) {
        List<List<String>> result = new ArrayList<>();
        for (char[][] chars : original) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                res.add(new String(chars[i]));
            }
            result.add(res);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new SolveNQueens().solveNQueens(4);
        System.out.println();
    }
}
