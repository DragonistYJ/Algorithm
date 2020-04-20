import java.util.*;

/*
NO834 树中距离之和
 */
public class Solution834 {
    List<Set<Integer>> graph = new ArrayList<>();
    int[] nodes;
    int[] ans;
    int num;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        nodes = new int[N];
        Arrays.fill(nodes, 1);
        ans = new int[N];
        num = N;

        for (int i = 0; i < N; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        countNodes(0, -1);
        calculateRoot(0, -1, 1);
        dfs(0, -1);

        int[] ret = new int[N];
        System.arraycopy(ans, 0, ret, 0, ans.length);
        return ret;
    }

    private void dfs(int node, int parent) {
        Set<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (child != parent) {
                ans[child] = ans[node] + num - nodes[child] * 2;
                dfs(child, node);
            }
        }
    }


    private void countNodes(int node, int parent) {
        Set<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (child != parent) {
                countNodes(child, node);
                nodes[node] += nodes[child];
            }
        }
    }

    private void calculateRoot(int node, int parent, int length) {
        Set<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (child != parent) {
                ans[0] += length;
                calculateRoot(child, node, length + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[] sum = new Solution834().sumOfDistancesInTree(6, edges);
        for (int i : sum) {
            System.out.println(i);
        }
    }
}
