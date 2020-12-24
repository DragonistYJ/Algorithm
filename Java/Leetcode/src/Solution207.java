import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
NO207 课程表
现在你总共有 n 门课需要选，记为 0 到 n-1。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
            inDegree[prerequisite[1]] += 1;
        }
        List<Integer> roots = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) roots.add(i);
        }
        while (!roots.isEmpty()) {
            Integer root = roots.get(0);
            roots.remove(0);
            List<Integer> nodes = graph.get(root);
            for (Integer node : nodes) {
                inDegree[node] -= 1;
                if (inDegree[node] == 0) roots.add(node);
            }
        }
        for (int i : inDegree) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] x = {{0, 1}, {0, 2}, {1, 2}, {1, 3}};
        System.out.println(new Solution207().canFinish(4, x));
    }
}
