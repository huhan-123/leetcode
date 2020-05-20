package two_points.collision_pointer;

/**
 * @Author: huhan
 * @Date 2020/5/20 8:47 上午
 * @Description 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * @Verion 1.0
 */
//https://leetcode-cn.com/problems/container-with-most-water/solution/shuang-zhi-zhen-fa-zheng-ming-jian-dan-yi-dong-bu-/
public class MaxArea {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1,result=0;
        while(left<right){
            result=Math.max(result,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{1,2,4,3}));
    }
}
