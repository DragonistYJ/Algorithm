import java.util.*;

/**
 * @ClassName Solution1466
 * @Author 11214
 * @Date 2020/6/6
 * @Description 重新规划路线
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 */
public class Solution1466 {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        List<HashSet<Integer>> dGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            dGraph.add(new HashSet<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
            dGraph.get(connections[i][0]).add(connections[i][1]);
        }

        int ans = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> list = graph.get(node);
            for (Integer integer : list) {
                if (visited[integer]) continue;
                if (!dGraph.get(integer).contains(node)) ans += 1;
                visited[integer] = true;
                queue.offer(integer);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] connections = {{1, 0}, {2, 0}};
        System.out.println(new Solution1466().minReorder(3, connections));
    }
}
