package modified_binary_search;

/**
 * @Author: huhan
 * @Date 2020/6/1 10:12 上午
 * @Description 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。你可以假设数组中不存在重复元素。
 * @Verion 1.0
 */

/**
 * 思路：旋转后的数组是部分有序的，分为较大的一部分和较小的一部分。所以这里有三种情况：
 * 1.数组没有旋转，nums[left]<nums[mid]<nums[right]
 * 2.数组旋转后，mid在较大的一部分中，nums[right]<nums[left]<nums[mid]
 * 3.数组旋转后，mid在较小的一部分中,nums[mid]<nums[right]<nums[left]
 */
public class FindMin {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        //注意这里循环结束后left和right为相邻的两个索引，结果只可能出现在这两个索引中
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid] && nums[left] < nums[right]) {   //数组没有旋转
                return nums[left];
            } else if (nums[mid] < nums[right]) {   //数组旋转后，mid在较大的一部分中
                right = mid;
            } else {    //数组旋转后，mid在较小的一部分中
                left = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
