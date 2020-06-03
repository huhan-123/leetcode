package topological_sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: huhan
 * @Date 2020/6/3 10:08 上午
 * @Description 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * @Verion 1.0
 */
public class ClassSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> inDegreeOfZero = new LinkedList<>();
        int[] inDegreeOfCourse = new int[numCourses];
        Node[] graph = new Node[numCourses];

        //初始化graph和inDegreeOfCourse
        for (int[] prerequisite : prerequisites) {
            if (graph[prerequisite[1]] == null) {
                graph[prerequisite[1]] = new Node(prerequisite[0]);
            } else {
                Node node = new Node(prerequisite[0]);
                node.next = graph[prerequisite[1]];
                graph[prerequisite[1]] = node;
            }
            inDegreeOfCourse[prerequisite[0]]++;
        }

        //初始化inDegreeOfZero
        for (int i = 0; i < numCourses; i++) {
            if (inDegreeOfCourse[i] == 0) {
                inDegreeOfZero.offer(i);
            }
        }

        //遍历课程的数目
        int count = 0;
        while (!inDegreeOfZero.isEmpty()) {
            Integer currentCourse = inDegreeOfZero.poll();
            count++;
            Node node = graph[currentCourse];
            //将依赖当前课程的课程入度减1
            while (node != null) {
                int inDgree = inDegreeOfCourse[node.course];
                if (--inDgree == 0) {
                    inDegreeOfZero.offer(node.course);
                }
                inDegreeOfCourse[node.course] = inDgree;
                node = node.next;
            }
        }

        if (count < numCourses) {
            return false;
        } else {
            return true;
        }
    }

    class Node {
        int course;
        Node next;

        public Node(int course) {
            this.course = course;
        }
    }

    public static void main(String[] args) {
        boolean b = new ClassSchedule().canFinish(2, new int[][]{{1, 0}, {0, 1}});
        System.out.println(b);
    }
}
