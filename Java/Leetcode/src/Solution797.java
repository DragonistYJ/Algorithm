import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution791
 * @Author 11214
 * @Date 2020/4/18
 * @Description TODO
 */
public class Solution797 {
    private List<List<Integer>> paths;
    private boolean[] visited;
    private int n;

    private void dfs(List<Integer> path, int[][] graph) {
        int node = path.get(path.size() - 1);
        if (node == n - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[node].length; i++) {
            int next = graph[node][i];
            if (!visited[next]) {
                visited[next] = true;
                path.add(next);
                dfs(path, graph);
                path.remove(path.size() - 1);
                visited[next] = false;
            }
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        if (n == 0) return new ArrayList<>();
        paths = new ArrayList<>();
        visited = new boolean[n];
        visited[0] = true;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(path, graph);
        return paths;
    }


}
