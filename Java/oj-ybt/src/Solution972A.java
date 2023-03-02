import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

/**
 * @author 11214
 * @since 2023/3/1 20:06
 */
public class Solution972A {
    private static class Node {
        int idx;
        int parent;
        boolean leaf = true;
        Node[] kids = new Node[2];
        long[] weights = new long[2];

        public Node(int idx, int parent) {
            this.idx = idx;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", parent=" + parent +
                    '}';
        }
    }

    private static long[][] dp;

    public static int dfs(Node node, int q) {
        if (node.leaf) {
            return 0;
        }

        int a = dfs(node.kids[0], q);
        int b = dfs(node.kids[1], q);
        int t = 2 + a + b;

        for (int i = 1; i <= Math.min(t, q); i++) { // 保留i树枝
            for (int ln = 0; ln <= i; ln++) {
                int rn = i - ln;
                long left = ln == 0 ? 0 : node.weights[0] + dp[node.kids[0].idx][ln - 1];
                long right = rn == 0 ? 0 : node.weights[1] + dp[node.kids[1].idx][rn - 1];
                dp[node.idx][i] = Math.max(dp[node.idx][i], left + right);
            }
        }
        return t;
    }

    public static Node makeTree(long[][] graph) {
        ArrayDeque<Node> deque = new ArrayDeque<>();
        Node root = new Node(1, 0);
        deque.offer(root);
        while (!deque.isEmpty()) {
            Node parent = deque.poll();
            int k = 0;
            for (int i = 0; i < graph[parent.idx].length; i++) {
                if (graph[parent.idx][i] != -1 && i != parent.parent) {
                    parent.leaf = false;
                    Node node = new Node(i, parent.idx);
                    parent.kids[k] = node;
                    parent.weights[k] = graph[parent.idx][i];
                    k += 1;
                    deque.offer(node);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int q = (int) st.nval;
        dp = new long[n + 1][q + 1];
        long[][] graph = new long[n + 1][n + 1];
        for (long[] longs : graph) {
            Arrays.fill(longs, -1);
        }
        for (int i = 0; i < n - 1; i++) {
            st.nextToken();
            int a = (int) st.nval;
            st.nextToken();
            int b = (int) st.nval;
            st.nextToken();
            long w = (long) st.nval;
            graph[a][b] = w;
            graph[b][a] = w;
        }

        Node root = makeTree(graph);
        dfs(root, q);
        System.out.println(dp[1][q]);
    }
}
