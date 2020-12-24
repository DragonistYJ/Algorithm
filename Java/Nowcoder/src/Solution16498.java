import java.util.*;

/**
 * @ClassName 寻找道路
 * @Author 11214
 * @Date 2020/4/4
 * @Description BFS
 */
public class Solution16498 {
    private static class Tuple {
        private int point;
        private int step;

        public Tuple(int point, int step) {
            this.point = point;
            this.step = step;
        }
    }

    private static HashSet<Integer> rDFS(List<List<Integer>> graph, int t, int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(t);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(t);
        while (!queue.isEmpty()) {
            Integer s = queue.poll();
            List<Integer> list = graph.get(s);
            for (Integer integer : list) {
                if (!hashSet.contains(integer)) queue.add(integer);
                hashSet.add(integer);
            }
        }
        HashSet<Integer> result = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (!hashSet.contains(i)) result.add(i);
        }
        List<Integer> adjoins = new ArrayList<>();
        for (Integer integer : result) {
            adjoins.addAll(graph.get(integer));
        }
        result.addAll(adjoins);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> rGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            rGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.get(x).add(y);
            rGraph.get(y).add(x);
        }
        int s = scanner.nextInt();
        int t = scanner.nextInt();

        HashSet<Integer> illegals = rDFS(rGraph, t, n);
        illegals.remove(s);

        Set<Integer> walked = new HashSet<>();
        walked.add(s);
        Queue<Tuple> queue = new ArrayDeque<>();
        queue.add(new Tuple(s, 0));
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            if (tuple.point == t) {
                System.out.println(tuple.step);
                return;
            }
            List<Integer> nextPoints = graph.get(tuple.point);
            for (Integer nextPoint : nextPoints) {
                if (!walked.contains(nextPoint) && !illegals.contains(nextPoint)) {
                    walked.add(nextPoint);
                    queue.offer(new Tuple(nextPoint, tuple.step + 1));
                }
            }
        }
        System.out.println(-1);
    }
}
