package modified_binary_search;

/**
 * @Author: huhan
 * @Date 2020/6/1 9:11 上午
 * @Description 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。每行的第一个整数大于前一行的最后一个整数.
 * @Verion 1.0
 */

/**
 * 先使用二分法搜索确定target可能在的行，然后在可能在的行中继续用二分法搜索
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        //该循环找出target可能存在的行，循环条件决定target只可能存在于rowStart或者rowEnd中（rowStart和rowEnd为相邻的两行）
        int rowCount = matrix.length, colCount = matrix[0].length;
        int rowStart = 0, rowEnd = rowCount - 1;
        while (rowStart + 1 < rowEnd) {
            int rowMid = rowStart + (rowEnd - rowStart) / 2;
            if (matrix[rowMid][0] == target) {
                return true;
            } else if (matrix[rowMid][0] < target) {
                rowStart = rowMid;
            } else {
                rowEnd = rowMid;
            }
        }

        //target只可能存在与rowStart或者rowEnd中
        if (matrix[rowStart][colCount - 1] == target) {
            return true;
        } else if (matrix[rowStart][colCount - 1] < target) {//target可能在rowEnd这一行
            return searchArray(matrix[rowEnd], target);
        } else {//target可能在rowEnd这一行
            return searchArray(matrix[rowStart], target);
        }
    }

    //在数组中使用二分搜索target
    public boolean searchArray(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[left] == target || array[right] == target;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        boolean b = new SearchMatrix().searchMatrix(matrix, 3);
        System.out.println();
    }
}
