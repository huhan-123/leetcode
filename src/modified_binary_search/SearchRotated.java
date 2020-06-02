package modified_binary_search;

/**
 * @Author: huhan
 * @Date 2020/6/1 4:18 下午
 * @Description 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * @Verion 1.0
 */
public class SearchRotated {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        //注意这里循环结束后left和right为相邻的两个索引，结果只可能出现在这两个索引中
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid] && nums[left] < nums[right]) {   //数组没有旋转
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<target){
                    left=mid;
                }else{
                    right=mid;
                }
            } else if (nums[mid] < nums[right]) {   //数组旋转后，mid在较小的一部分中
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<target){
                    if(nums[right]<target){
                        right=mid;
                    }else{
                        left=mid;
                    }
                }else{
                    right = mid;
                }
            } else {    //数组旋转后，mid在较大的一部分中
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<target){
                    left=mid;
                }else{
                    if(nums[left]>target){
                        left = mid;
                    }else{
                        right = mid;
                    }
                }
            }
        }
        if(nums[left]==target){
            return left;
        }else if(nums[right]==target){
            return right;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int search = new SearchRotated().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(search);
    }
}
