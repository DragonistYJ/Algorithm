import java.util.HashMap;

/**
 * @author 11214
 * @since 2022/12/1 10:44
 * <p>
 * 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。给你一个二维数组 graph ，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。
 * 形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
 * 不存在自环（graph[u] 不包含 u）。
 * 不存在平行边（graph[u] 不包含重复值）。
 * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
 * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
 * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
 * 如果图是二分图，返回 true ；否则，返回 false 。
 */
public class Solution785 {
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

    public boolean isBipartite(int[][] graph) {
        UnionSet unionSet = new UnionSet();
        for (int[] ints : graph) {
            for (int j = 0; j < ints.length - 1; j++) {
                unionSet.union(ints[j], ints[j + 1]);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (unionSet.find(i).equals(unionSet.find(graph[i][j]))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{4}, {}, {4}, {4}, {0, 2, 3}};
        System.out.println(new Solution785().isBipartite(graph));
    }
}
