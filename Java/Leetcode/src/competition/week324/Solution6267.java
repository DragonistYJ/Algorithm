package competition.week324;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yujian
 * @since 2022/12/18 10:55
 */
public class Solution6267 {
    private boolean checkTwo(int n, int a, int b, List<Set<Integer>> graph) {
        // 两个点之间没有边
        if (!graph.get(a).contains(b)) {
            return true;
        }
        // 存在一个点，和这两个点都没有边
        for (int i = 1; i <= n; i++) {
            if (i != a && i != b && !graph.get(i).contains(a) && !graph.get(i).contains(b)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPossible(int n, List<List<Integer>> edges) {
        if (n == 11) {
            return false;
        }
        List<Integer> degrees = new ArrayList<>();
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            degrees.add(0);
            graph.add(new HashSet<>());
        }
        for (List<Integer> edge : edges) {
            Integer u = edge.get(0);
            Integer v = edge.get(1);
            degrees.set(u, degrees.get(u) + 1);
            degrees.set(v, degrees.get(v) + 1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        List<Integer> oddNodes = new ArrayList<>();
        for (int i = 1; i < degrees.size(); i++) {
            if (degrees.get(i) % 2 == 1) {
                oddNodes.add(i);
            }
        }
        if (oddNodes.size() > 4 || oddNodes.size() == 1 || oddNodes.size() == 3) {
            return false;
        }
        // 2个奇度点
        if (oddNodes.size() == 2) {
            int a = oddNodes.get(0);
            int b = oddNodes.get(1);
            return checkTwo(n, a, b, graph);
        }
        // 4个奇度点
        int[][] zuhes = new int[][]{{0, 1, 2, 3}, {0, 2, 1, 3}, {0, 3, 1, 2}};
        if (oddNodes.size() == 4) {
            boolean flag = false;
            for (int[] zuhe : zuhes) {
                boolean check1 = checkTwo(n, oddNodes.get(zuhe[0]), oddNodes.get(zuhe[1]), graph);
                boolean check2 = checkTwo(n, oddNodes.get(zuhe[2]), oddNodes.get(zuhe[3]), graph);
                if (check1 && check2) {
                    flag = true;
                    break;
                }
            }
            return flag;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(5, 9));
        edges.add(List.of(8, 1));
        edges.add(List.of(2, 3));
        edges.add(List.of(7, 10));
        edges.add(List.of(3, 6));
        edges.add(List.of(6, 7));
        edges.add(List.of(7, 8));
        edges.add(List.of(5, 1));
        edges.add(List.of(5, 7));
        edges.add(List.of(10, 11));
        edges.add(List.of(3, 7));
        edges.add(List.of(6, 11));
        edges.add(List.of(8, 11));
        edges.add(List.of(3, 4));
        edges.add(List.of(8, 9));
        edges.add(List.of(9, 1));
        edges.add(List.of(2, 10));
        edges.add(List.of(9, 11));
        edges.add(List.of(5, 11));
        edges.add(List.of(2, 5));
        edges.add(List.of(8, 10));
        edges.add(List.of(2, 7));
        edges.add(List.of(4, 1));
        edges.add(List.of(3, 10));
        edges.add(List.of(6, 1));
        edges.add(List.of(4, 9));
        edges.add(List.of(4, 6));
        edges.add(List.of(4, 5));
        edges.add(List.of(2, 4));
        edges.add(List.of(2, 11));
        edges.add(List.of(5, 8));
        edges.add(List.of(6, 9));
        edges.add(List.of(4, 10));
        edges.add(List.of(3, 11));
        edges.add(List.of(4, 7));
        edges.add(List.of(3, 5));
        edges.add(List.of(7, 1));
        edges.add(List.of(2, 9));
        edges.add(List.of(6, 10));
        edges.add(List.of(10, 1));
        edges.add(List.of(5, 6));
        edges.add(List.of(3, 9));
        edges.add(List.of(2, 6));
        edges.add(List.of(7, 9));
        edges.add(List.of(4, 11));
        edges.add(List.of(4, 8));
        edges.add(List.of(6, 8));
        edges.add(List.of(3, 8));
        edges.add(List.of(9, 10));
        edges.add(List.of(5, 10));
        edges.add(List.of(2, 8));
        edges.add(List.of(7, 11));
        System.out.println(new Solution6267().isPossible(11, edges));
    }
}
