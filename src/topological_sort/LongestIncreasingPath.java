package topological_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/6/3 2:32 下午
 * @Description 给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * @Verion 1.0
 */
public class LongestIncreasingPath {
    public final static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //方法一：深度优先搜索+缓存
    public int longestIncreasingPath(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(result, currentLongestPath(grid, i, j, cache));
            }
        }
        return result;
    }

    public int currentLongestPath(int[][] grid, int row, int col, int[][] cache) {
        //用缓存存储计算过的位置的最长路径
        if (cache[row][col] != 0) {
            return cache[row][col];
        } else {
            for (int i = 0; i < dir.length; i++) {
                int x = row + dir[i][0], y = col + dir[i][1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] > grid[row][col]) {
                    cache[row][col] = Math.max(cache[row][col], currentLongestPath(grid, row + dir[i][0], col + dir[i][1], cache));
                }
            }
        }

        return ++cache[row][col];
    }

    //方法二：拓扑排序
    private int m, n;

    public int longestIncreasingPath2(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        // padding the matrix with zero as boundaries
        // assuming all positive integer, otherwise use INT_MIN as boundaries
        int[][] matrix = new int[m + 2][n + 2];
        for (int i = 0; i < m; ++i)
            System.arraycopy(grid[i], 0, matrix[i + 1], 1, n);

        // calculate outdegrees
        int[][] outdegree = new int[m + 2][n + 2];
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                for (int[] d : dir)
                    if (matrix[i][j] < matrix[i + d[0]][j + d[1]])
                        outdegree[i][j]++;

        // find leaves who have zero out degree as the initial level
        n += 2;
        m += 2;
        List<int[]> leaves = new ArrayList<>();
        for (int i = 1; i < m - 1; ++i)
            for (int j = 1; j < n - 1; ++j)
                if (outdegree[i][j] == 0) leaves.add(new int[]{i, j});

        // remove leaves level by level in topological order
        int height = 0;
        while (!leaves.isEmpty()) {
            height++;
            List<int[]> newLeaves = new ArrayList<>();
            for (int[] node : leaves) {
                for (int[] d : dir) {
                    int x = node[0] + d[0], y = node[1] + d[1];
                    if (matrix[node[0]][node[1]] > matrix[x][y])
                        if (--outdegree[x][y] == 0)
                            newLeaves.add(new int[]{x, y});
                }
            }
            leaves = newLeaves;
        }
        return height;
    }

    public static void main(String[] args) {
        int i = new LongestIncreasingPath().longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}});
        System.out.println(i);
    }
}
