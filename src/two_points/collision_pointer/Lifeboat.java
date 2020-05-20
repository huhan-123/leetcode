package two_points.collision_pointer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: huhan
 * @Date 2020/5/17 11:17 上午
 * @Description 救生艇
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * @Verion 1.0
 */
//思路：如果最大重量的人不能和最小重量的人同坐一艘船，则他只能单独做一艘船
public class Lifeboat {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0, l = 0, r = people.length - 1;
        Arrays.sort(people);
        while (l < r) {
            if (people[l] + people[r] <= limit) {
                count++;
                l++;
                r--;
            } else {
                count++;
                r--;
            }
        }
        if (l == r) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Lifeboat().numRescueBoats(new int[]{1,2,2}, 3));
    }
}
