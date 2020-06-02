package modified_binary_search;

/**
 * @Author: huhan
 * @Date 2020/6/1 7:35 下午
 * @Description 平方根
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * @Verion 1.0
 */

/**
 * 二分法：比较mid*mid和x的大小，如果相差小于精度值，则返回，否则更新left或者right的值
 * x有几种可能的情况：
 * 1.x==0或x==1，平方根等于x
 * 2.x<1,平方根范围是(x,1)
 * 3.x>1，平方根范围是(1,x)
 *
 * 按值二分套路：选定答案出现的范围，然后去确认每次的二分中点大了，或是小了，再相应的移动前后指针
 */
public class Sqrt {
    public double mySqrt(double x) {
        if (x == 0 || x == 1) {
            return x;
        }

        double left = 1, right = x, precision = 1e-7;

        //如果输入的数小于1，平方根的范围在（x,1）
        if (x < 1.0) {
            left = x;
            right = 1;
        }

        while (right - left > precision) {
            double mid = left + (right - left) / 2;
            if (Math.abs(mid * mid - x) < precision) {
                return mid;
            } else if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        double v = new Sqrt().mySqrt(4);
        System.out.println(v);
    }
}
