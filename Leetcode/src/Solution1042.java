import java.util.ArrayList;
import java.util.List;

/*
NO1042 不邻接植花
有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
另外，没有花园有 3 条以上的路径可以进入或者离开。
你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 */
public class Solution1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] color = new int[N];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }
        color[0] = 1;
        for (int i = 2; i <= N; i++) {
            int[] used = new int[5];
            List<Integer> neighbors = graph.get(i);
            for (Integer neighbor : neighbors) {
                used[color[neighbor - 1]] = 1;
            }
            for (int j = 1; j < used.length; j++) {
                if (used[j] == 0) {
                    color[i - 1] = j;
                    break;
                }
            }
        }
        return color;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 2}, {2, 3}, {3, 1}, {3, 4}, {4, 1}, {2, 4}};
        int[] adjs = new Solution1042().gardenNoAdj(4, x);
        for (int adj : adjs) {
            System.out.println(adj);
        }
    }
}
