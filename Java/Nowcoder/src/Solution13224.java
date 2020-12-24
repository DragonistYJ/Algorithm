import java.util.*;

/**
 * @ClassName 送外卖
 * @Author 11214
 * @Date 2020/4/4
 * @Description BFS
 */
public class Solution13224 {
    private static Set<Integer> reachable(List<List<Integer>> graph) {
        int n = graph.size();
        Set<Integer> walked = new HashSet<>();
        walked.add(n - 1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n - 1);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> list = graph.get(poll);
            for (Integer integer : list) {
                if (!walked.contains(integer)) {
                    walked.add(integer);
                    queue.add(integer);
                }
            }
        }
        return walked;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (i + a[i] >= 0 && i + a[i] < n && a[i] != 0) {
                graph.get(i + a[i]).add(i);
            }
            if (i + b[i] >= 0 && i + b[i] < n && b[i] != 0) {
                graph.get(i + b[i]).add(i);
            }
        }
        Set<Integer> reachable = reachable(graph);
        if (!reachable.contains(0)) {
            System.out.println("No solution!");
            return;
        }

        Set<Integer> walked = new HashSet<>();
        walked.add(0);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == n - 1) break;
            int nextA = poll + a[poll];
            if (reachable.contains(nextA)) {
                if (walked.contains(nextA)) {
                    System.out.println("Infinity!");
                    return;
                }
                queue.add(nextA);
                walked.add(nextA);
                builder.append('a');
                continue;
            }
            int nextB = poll + b[poll];
            if (reachable.contains(nextB)) {
                if (walked.contains(nextB)) {
                    System.out.println("Infinity!");
                    return;
                }
                queue.add(nextB);
                walked.add(nextB);
                builder.append('b');
            }
        }
        System.out.println(builder.toString());
    }
}
