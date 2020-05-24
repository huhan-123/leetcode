package cyclic_sort;

/**
 * @Author: huhan
 * @Date 2020/5/23 8:48 下午
 * @Description 消失的两个数字
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * @Verion 1.0
 */
public class MissingTwo {
    public int[] missingTwo(int[] nums) {
        int[] result = new int[2];
        int n = nums.length + 2, j = 0;
        boolean[] hash = new boolean[n];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i] - 1] = true;
        }
        for (int i = 0; i < hash.length; i++) {
            if (!hash[i]) {
                result[j++] = i + 1;
            }
        }
        return result;
    }
}
