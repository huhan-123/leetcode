package modified_binary_search;

/**
 * @Author: huhan
 * @Date 2020/6/2 5:32 下午
 * @Description 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * @Verion 1.0
 */

/**
 * 第k小的数字意味着小于等于它的元素一共有k个，大于它的数字有n*n-k个。假设某个数为mid
 * 如果小于等于mid的元素个数小于k，说明mid不是第k小的数，比mid小的数就更不可能是了。所以第k小的数至少是mid + 1。
 * 如果小于等于mid的元素个数大于等于k，说明mid可能为第k小的数，比它小的数也有可能是答案。
 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int left = matrix[0][0], right = matrix[length - 1][length - 1];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (LessThanEqualToMid(matrix, mid) >= k) {
                right = mid;
            } else {
                left = mid;
            }
        }

        //可能left的初始值就是答案
        if (LessThanEqualToMid(matrix, left) >= k) {
            return left;
        }
        return right;
    }

    //从左下角的元素向上查找
    public int LessThanEqualToMid(int[][] matrix, int mid) {
        int count = 0, row = matrix.length - 1, col = 0;
        while (row >= 0 && col < matrix.length) {
            if (matrix[row][col] <= mid) {
                count = count + row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = new KthSmallest().kthSmallest(new int[][]{{1, 2}, {1, 3}}, 1);
        System.out.println(i);
    }
}
