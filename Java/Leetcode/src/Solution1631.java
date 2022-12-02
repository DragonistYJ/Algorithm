import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author 11214
 * @since 2022/12/2 9:54
 */
public class Solution1631 {
    private static class Edge {
        public int u;
        public int v;
        public int effort;

        public Edge(int u, int v, int effort) {
            this.u = u;
            this.v = v;
            this.effort = effort;
        }
    }

    private static class UnionSet {
        public HashMap<Integer, Integer> map = new HashMap<>();

        public Integer find(Integer x) {
            if (!map.containsKey(x)) {
                map.put(x, x);
            }
            if (!x.equals(map.get(x))) {
                map.put(x, find(map.get(x)));
            }
            return map.get(x);
        }

        public void union(Integer x, Integer y) {
            Integer rootX = find(x);
            Integer rootY = find(y);
            if (rootX.equals(rootY)) {
                return;
            }
            map.put(rootX, rootY);
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<Edge> edges = new ArrayList<>();
        UnionSet unionSet = new UnionSet();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j < m - 1) {
                    edges.add(new Edge(i * m + j, i * m + j + 1, Math.abs(heights[i][j] - heights[i][j + 1])));
                }
                if (i < n - 1) {
                    edges.add(new Edge(i * m + j + m, i * m + j, Math.abs(heights[i][j] - heights[i + 1][j])));
                }
                unionSet.find(i * m + j);
            }
        }

        edges.sort(Comparator.comparingInt(o -> o.effort));
        int end = n * m - 1;
        for (Edge edge : edges) {
            unionSet.union(edge.u, edge.v);
            if (unionSet.find(0).equals(unionSet.find(end))) {
                return edge.effort;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{{4, 3, 4, 10, 5, 5, 9, 2}, {10, 8, 2, 10, 9, 7, 5, 6}, {5, 8, 10, 10, 10, 7, 4, 2}, {5, 1, 3, 1, 1, 3, 1, 9}, {6, 4, 10, 6, 10, 9, 4, 6}};
        System.out.println(new Solution1631().minimumEffortPath(heights));
    }
}
