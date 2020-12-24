import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution310
 * @Author 11214
 * @Date 2020/6/10
 * @Description 最小高度树
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 * 格式
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 */
public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]] += 1;
            degree[edge[1]] += 1;
        }

        boolean[] visited = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        while (true) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1 && !visited[i]) {
                    visited[i] = true;
                    temp.add(i);
                } else if (degree[i] == 0 && !visited[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    return list;
                }
            }
            for (Integer node : temp) {
                List<Integer> list = graph.get(node);
                for (Integer integer : list) {
                    degree[integer] -= 1;
                }
            }
            if (temp.isEmpty()) {
                return ans;
            } else {
                ans.clear();
                ans.addAll(temp);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(new Solution310().findMinHeightTrees(6, edges));
    }
}
