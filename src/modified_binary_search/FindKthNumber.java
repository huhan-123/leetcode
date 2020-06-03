package modified_binary_search;

/**
 * @Author: huhan
 * @Date 2020/6/2 7:47 上午
 * @Description 乘法表中第k小的数
 * 几乎每一个人都用乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k小的数字。
 * @Verion 1.0
 */
public class FindKthNumber {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isGreaterThanEqualTo(m, n, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isGreaterThanEqualTo(m, n, k, left)) {
            return left;
        }
        return right;
    }

    //乘法表中比mid小的数字是否大于等于k
    public boolean isGreaterThanEqualTo(int m, int n, int k, int mid) {
        int res = 0;
        for (int i = 1; i <= m; ++i) {
            res += Math.min(mid / i, n);
        }

        return res >= k;
    }
}
