package two_heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: huhan
 * @Date 2020/5/28 3:17 下午
 * @Description 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。
 * 最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
 * @Verion 1.0
 */
public class FindMaximizedCapital {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> bigQueue = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o2.profit - o1.profit;
            }
        });
        PriorityQueue<Project> littleQueue = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o1.capital - o2.capital;
            }
        });

        for (int i = 0; i < profits.length; i++) {
            Project project = new Project(profits[i], capital[i]);
            if (project.capital <= w) {
                bigQueue.offer(project);
            } else {
                littleQueue.offer(project);
            }
        }

        while (k > 0 && !bigQueue.isEmpty()) {
            w += bigQueue.poll().profit;
            while (!littleQueue.isEmpty()) {
                if (littleQueue.peek().capital <= w) {
                    bigQueue.offer(littleQueue.poll());
                }else {
                    break;
                }
            }
            k--;
        }

        return w;
    }

    static class Project {
        int profit;
        int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindMaximizedCapital().findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
    }
}
