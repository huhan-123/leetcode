package modified_binary_search;

/**
 * @Author: huhan
 * @Date 2020/6/1 7:35 上午
 * @Description 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * @Verion 1.0
 */

/**
 * 其实题目就是要找最先出现的元素，在这种情况下，如果我们找到了元素，依旧不知道它是不是最先（小）的，
 * 但是我们知道答案肯定不在后面，肯定在这或者是之前，因此这种情况需要将尾指针往前移。最后找到相邻两个不同
 * 元素的位置再判断一下就可以找到第一个出现的元素
 */
public class VersionControl {
    //这个方法只是为了不让编译器不报错写的，没有实际逻辑，leetcode原题已经提供，不需要自己完成
    public boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isBadVersion(left)) {//第一个元素就是要找的
            return left;
        }
        return right;
    }
}
