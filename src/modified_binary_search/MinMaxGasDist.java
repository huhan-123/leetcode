package modified_binary_search;

/**
 * @Author: huhan
 * @Date 2020/6/1 9:29 下午
 * @Description 给定一个升序排列的数组，里面表示的是已经建好的加油站的位置，现在要新建 K 个加油站，怎么建，
 * 使得所有相邻加油站的间距的最大值最小，求最后所有相邻加油站的间距的最大值。
 * @Verion 1.0
 */

/**
 * 思路：选定答案出现的范围，然后去确认每次的二分中点大了，或是小了，再相应的移动前后指针。这里，最小间距肯定不可能小于0，
 * 最大间距不会超过题目给的最大位置，我们把这个当作二分的初始值，判断条件是，满足二分中点这样的最大间距总共需要新建多少个
 * 加油站，看一下这个数目是否比 K 大。
 */
public class MinMaxGasDist {
    public double minmaxGasDist(int[] stations, int k) {
        double left = 0.0, right = stations[stations.length - 1], precision = 1e-7;
        while (right - left > precision) {
            double mid = (left + right) / 2;
            if (countStationNeeded(stations, mid) <= k) {//需要的加油站小于k，证明距离大了，需要的加油站等于k，距离可能可以更小
                right = mid;
            } else {//需要的加油站大于k，证明距离小了
                left = mid;
            }
        }
        return left;
    }

    public int countStationNeeded(int[] stations, double distance) {
        int k = 0;
        for (int i = 1; i < stations.length; i++) {
            // 两个加油站间距除以期望的间距(二分中点)，表示说当前这个间距是期望的间距的多少倍
            // 这个倍数减 1 就是我们要新建的加油站的数目（取整已经帮我们做了这一步）
            k += (int) ((stations[i] - stations[i - 1]) / distance);
        }
        return k;
    }
}
