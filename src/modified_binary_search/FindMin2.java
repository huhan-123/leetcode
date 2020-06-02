package modified_binary_search;

/**
 * @Author: huhan
 * @Date 2020/6/1 4:39 下午
 * @Description 寻找旋转排序数组中的最小值 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 * @Verion 1.0
 */
public class FindMin2 {
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
            } else if (nums[mid] < nums[right]) {   //数组旋转后，mid在较小的一部分中
                right = mid;
            } else if(nums[mid]>nums[right]) {    //数组旋转后，mid在较大的一部分中
                left = mid;
            }else {
                right--;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
