package modified_binary_search;

/**
 * @Author: huhan
 * @Date 2020/6/1 8:14 上午
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。如果数组中不存在目标值，返回 [-1, -1]。
 * @Verion 1.0
 */

/**
 * 思路：先找到两个相邻的两个target的索引，再向两边扩散
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[left] == target && nums[right] == target) {    //找到两个相邻的target，向两边扩散
            while (left >= 0 && nums[left] == target) {
                left--;
            }
            while (right < nums.length && nums[right] == target) {
                right++;
            }
            return new int[]{left+1, right-1};
        } else if (nums[left] == target && nums[right] != target) { //找到一个target，向左边扩散
            right = left;
            while (left >= 0 && nums[left] == target) {
                left--;
            }
            return new int[]{left+1, right};
        } else if (nums[left] != target && nums[right] == target) { //找到一个target，向右边扩散
            left = right;
            while (right < nums.length && nums[right] == target) {
                right++;
            }
            return new int[]{left, right-1};
        } else {    //一个target都没有找到
            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        int[] ints = new SearchRange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println();
    }
}
