package cyclic_sort;

/**
 * @Author: huhan
 * @Date 2020/5/22 9:06 下午
 * @Description 找数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * @Verion 1.0
 */

/**
 * 思路：如果没有重复的数字，那么正常排序后，数字i应该在下标为i的位置。重头扫描数组，如果下标为i的
 * 数字不是i的话，（假设为m），那么就和下标为m的数字交换。在交换的过程中如果有重复的数字，则终止循环。
 */

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //这里的循环很关键
            while (nums[i] != i) {
                int temp = nums[i];
                if (nums[temp] == temp) {
                    return nums[i];
                }
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindRepeatNumber().findRepeatNumber(new int[]{2, 3, 0, 0, 1, 5, 6}));
    }
}
