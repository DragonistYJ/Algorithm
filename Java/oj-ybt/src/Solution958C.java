import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author 11214
 * @since 2023/3/7 11:43
 */
public class Solution958C {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        long[] costs = new long[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            costs[i] = (long) st.nval;
        }
        long[][] edges = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                st.nextToken();
                edges[i][j] = (long) st.nval;
            }
        }
        int curr = 0;
        long min = costs[0];
        for (int i = 1; i < n; i++) {
            if (costs[i] < min) {
                min = costs[i];
                curr = i;
            }
        }

        long sum = costs[curr];
        boolean[] visited = new boolean[n];
        visited[curr] = true;
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[curr] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[j] && edges[curr][j] < dist[j]) {
                    dist[j] = edges[curr][j];
                }
            }
            min = Long.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < min) {
                    curr = j;
                    min = dist[j];
                }
            }
            visited[curr] = true;
            sum += Math.min(min, costs[curr]);
        }

        System.out.println(sum);
    }
}
