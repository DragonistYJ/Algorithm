import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2023/3/2 19:27
 */
public class Solution972D {
    private static class Node {
        private final int idx;
        private final List<Node> neighbors = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    '}';
        }
    }

    private static int[][] dp;

    private static void removeParent(Node node, Node parent) {
        node.neighbors.removeIf(n -> n == parent);

        for (Node neighbor : node.neighbors) {
            removeParent(neighbor, node);
        }
    }

    private static void dfs(Node node) {
        if (node.neighbors.size() == 0) {
            dp[node.idx][0] = 0;
            dp[node.idx][1] = 1;
            return;
        }
        for (Node neighbor : node.neighbors) {
            dfs(neighbor);
        }

        // 选自己
        dp[node.idx][1] = 1;
        for (Node neighbor : node.neighbors) {
            dp[node.idx][1] += Math.min(dp[neighbor.idx][0], dp[neighbor.idx][1]);
        }
        // 不选自己
        for (Node neighbor : node.neighbors) {
            dp[node.idx][0] += dp[neighbor.idx][1];
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        dp = new int[n][2];
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < n; i++) {
            st.nextToken();
            int idx = (int) st.nval;
            st.nextToken();
            int k = (int) st.nval;
            for (int j = 0; j < k; j++) {
                st.nextToken();
                int v = (int) st.nval;
                nodes[idx].neighbors.add(nodes[v]);
                nodes[v].neighbors.add(nodes[idx]);
            }
        }
        removeParent(nodes[0], null);
        dfs(nodes[0]);
        System.out.println(Math.min(dp[0][0], dp[0][1]));
    }
}
