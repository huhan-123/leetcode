package cyclic_sort;

/**
 * @Author: huhan
 * @Date 2020/5/22 10:20 下午
 * @Description 消失的数字
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * @Verion 1.0
 */

/**
 * 思路：新建一个boolean数组，数组长度为n，其中出除了缺失整数的索引对应值为false，其它全为false
 */
public class MissingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            boolean[] hash = new boolean[nums.length+1];
            for(int i=0;i<nums.length;i++){
                hash[nums[i]]=true;
            }
            for(int i=0;i<hash.length;i++){
                if(!hash[i]){
                    return i;
                }
            }
            return -1;
        }
    }
}
