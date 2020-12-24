import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
NO684 冗余连接
在本问题中, 树指的是一个连通且无环的无向图。
输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 */
public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[][] graph = new int[n + 1][n + 1];
        int[] degree = new int[n + 1];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
            degree[edge[0]] += 1;
            degree[edge[1]] += 1;
        }
        List<Integer> leaves = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 1) leaves.add(i);
        }
        while (!leaves.isEmpty()) {
            Integer leaf = leaves.get(0);
            leaves.remove(0);
            degree[leaf] -= 1;
            for (int i = 1; i <= n; i++) {
                if (graph[leaf][i] == 1) {
                    degree[i] -= 1;
                    graph[leaf][i] = 0;
                    graph[i][leaf] = 0;
                    if (degree[i] == 1) {
                        leaves.add(i);
                    }
                }
            }
        }
        HashSet<Integer> circleNodes = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] != 0) circleNodes.add(i);
        }
        int[] ans = new int[2];
        for (int i = edges.length - 1; i >= 0; i--) {
            if (circleNodes.contains(edges[i][0]) && circleNodes.contains(edges[i][1])) {
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] x = {{9, 10}, {5, 8}, {2, 6}, {1, 5}, {3, 8}, {4, 9}, {8, 10}, {4, 10}, {6, 8}, {7, 9}};
        int[] connection = new Solution684().findRedundantConnection(x);
        for (int i : connection) {
            System.out.println(i);
        }
    }
}
