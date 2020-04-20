import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 课程表2
 * @Author 11214
 * @Date 2020/4/18
 * @Category 拓扑排序
 * @Description 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegrees[prerequisite[0]] += 1;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
                ans.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer pre = queue.poll();
            List<Integer> courses = graph.get(pre);
            for (Integer course : courses) {
                inDegrees[course] -= 1;
                if (inDegrees[course] == 0) {
                    queue.offer(course);
                    ans.add(course);
                }
            }
        }
        if (ans.size() != numCourses) return new int[0];
        int[] ret = new int[numCourses];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }
}
