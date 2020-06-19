package dp;

import java.util.Arrays;

/**
 * @Author: huhan
 * @Date 2020/6/3 9:27 下午
 * @Description 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * @Verion 1.0
 */

/**
 * 思路：思路就是建立长度为K的桶，每个桶中事先放入均分计算得到的元素值，然后每次向桶中放入新的元素时减去新元素的值，
 * 并判断相减之后的值是否大于数组由小到大排序后的第一个值也就是最小值，如果大于就说明可以继续放下一个数。再通过该
 * 递归函数判断下一个数可不可以放到该桶中（有可能由于下一个数过大而无法放入，那么这时就得向前挪移一个单元试试比他小
 * 的数可不可以放入桶中） 就这样依次递归下去 直到这个桶完全放满为止。然后再放下一个桶，直到所有的元素都放入了桶中，
 * 就说明可以把这个数组分成K个非空子集，其总和都相等。
 */
//https://www.jianshu.com/p/033d1697122e
public class PartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        sum /= k;

        //如果数组中最大的数大于总和，直接返回false
        Arrays.sort(nums);
        if (nums[nums.length - 1] > sum) {
            return false;
        }

        //初始化每个子集的总和
        int[] sumOfSubsets = new int[k];
        Arrays.fill(sumOfSubsets, sum);

        return help(nums, nums.length - 1, sumOfSubsets);

    }

    //把当前元素放到k个桶中的一个，是否能使得每个子集的总和相等，如果放入所有的桶都不能使得每个子集总和相等，说明不能划分为k个相等的子集
    public boolean help(int[] nums, int currentIndex, int[] sumOfSubsets) {
        //所有的元素都放入了桶中,此时所有桶的总和都相等
        if (currentIndex == -1) {
            return true;
        }

        //将当前元素放到k个桶中的一个
        for (int i = 0; i < sumOfSubsets.length; i++) {
            //如果该桶正好能放下当前元素或者放下该元素后还能放下其它的元素,则将该元素放入桶中
            if (sumOfSubsets[i] == nums[currentIndex] || sumOfSubsets[i] - nums[currentIndex] >= nums[0]) {
                //将当前元素放入该桶中
                sumOfSubsets[i]-=nums[currentIndex];
                //将下个元素递归放入桶中
                if (help(nums, currentIndex - 1, sumOfSubsets)) {
                    return true;
                }
                //当前元素不能放入该桶
                sumOfSubsets[i]+=nums[currentIndex];
            }
        }
        //将该元素放入所有的桶中都不能使得桶的和相等
        return false;
    }

    public static void main(String[] args) {
        boolean b = new PartitionKSubsets().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
        System.out.println(b);
    }
}
