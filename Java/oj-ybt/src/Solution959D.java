import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author 11214
 * @since 2023/3/7 12:08
 */
public class Solution959D {
    private static class Node {
        private int n = 0;
        private final int[] vs = new int[1010];
        private final int[] ds = new int[1010];

        public void addEdge(int v, int d) {
            vs[n] = v;
            ds[n] = d;
            n += 1;
        }
    }

    private static Node[] cows;

    private static void dijkstra() {

    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;
        st.nextToken();
        int x = (int) st.nval - 1;
        cows = new Node[n];
        for (int i = 0; i < cows.length; i++) {
            cows[i] = new Node();
        }
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int a = (int) st.nval - 1;
            st.nextToken();
            int b = (int) st.nval - 1;
            st.nextToken();
            int d = (int) st.nval;
            cows[a].addEdge(b, d);
        }

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, 110 * n);
        dist[x] = 0;
        visited[x] = true;
        for (int i = 1; i < n; i++) {
            Node cow = cows[x];
            for (int j = 0; j < cow.n; j++) {
                if (!visited[cow.vs[j]] && dist[cow.vs[j]] > dist[x] + cow.ds[cow.vs[j]]) {
                    dist[cow.vs[j]] = dist[x] + cow.ds[cow.vs[j]];
                }
            }
            int min = 110 * n;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < min) {
                    x = j;
                    min = dist[j];
                }
            }
            visited[x] = true;
        }

        int ans = 0;
        for (int d : dist) {
            ans = Math.max(ans, d * 2);
        }
        System.out.println(ans);
    }
}
