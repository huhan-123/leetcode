package two_points.collision_pointer;

/**
 * @Author: huhan
 * @Date 2020/5/20 10:35 上午
 * @Description 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @Verion 1.0
 */
//https://www.jianshu.com/p/a72150138cd7
public class CatchRain {
    public int catchRain(int[] height) {
        int result = 0, leftMax = 0, rightMax = height.length - 1, temp;
        //矮的柱子往高的柱子移动
        while (leftMax < rightMax) {
            if (height[leftMax] < height[rightMax]) {
                temp = leftMax + 1;
                while (height[temp] < height[leftMax]) {
                    result += (height[leftMax] - height[temp++]);
                }
                leftMax = temp;
            } else {
                temp = rightMax - 1;
                while (height[temp] < height[rightMax]) {
                    result += (height[rightMax] - height[temp--]);
                }
                rightMax = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CatchRain().catchRain(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
