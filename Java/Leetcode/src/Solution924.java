import java.util.*;

/**
 * @ClassName Solution924
 * @Author 11214
 * @Date 2020/6/9
 * @Description 尽量减少恶意软件的传播
 * 在节点网络中，只有当 graph[i][j] = 1 时，每个节点 i 能够直接连接到另一个节点 j。
 * 一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传播将继续，直到没有更多的节点可以被这种方式感染。
 * 假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。
 * 我们可以从初始列表中删除一个节点。如果移除这一节点将最小化 M(initial)， 则返回该节点。如果有多个节点满足条件，就返回索引最小的节点。
 * 请注意，如果某个节点已从受感染节点的列表 initial 中删除，它以后可能仍然因恶意软件传播而受到感染。
 */
public class Solution924 {
    private int find(int[] group, int i) {
        if (group[i] == i) return i;
        else return group[i] = find(group, group[i]);
    }

    private void union(int[] group, int i, int j) {
        int g1 = find(group, i);
        int g2 = find(group, j);
        group[g1] = g2;
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int[] group = new int[n];
        for (int i = 0; i < n; i++) group[i] = i;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1) union(group, i, j);
            }
        }
        HashMap<Integer, Integer> groupSize = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = find(group, i);
            groupSize.put(parent, groupSize.getOrDefault(parent, 0) + 1);
        }
        Arrays.sort(initial);
        List<Integer> once = new ArrayList<>();
        for (int i = 0; i < initial.length; i++) {
            boolean flag = true;
            for (int j = 0; j < initial.length; j++) {
                if (i == j) continue;
                if (find(group, initial[i]) == find(group, initial[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) once.add(initial[i]);
        }
        if (once.size() == 0) return initial[0];
        once.sort((o1, o2) -> groupSize.get(find(group, o2)) - groupSize.get(find(group, o1)));
        return once.get(0);
    }

    public static void main(String[] args) {
        int[][] group = {{1, 0, 0}, {0, 1, 1}, {0, 1, 1}};
        int[] init = {0, 2};
        System.out.println(new Solution924().minMalwareSpread(group, init));
    }
}
