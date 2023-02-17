import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author 11214
 * @since 2023/2/17 9:41
 */
public class Solution953C {
    public static void main(String[] args) throws IOException {
        int[][] directions = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};

        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        while (n-- > 0) {
            st.nextToken();
            int l = (int) st.nval;
            int[] grid = new int[l * l];
            st.nextToken();
            int x = (int) st.nval;
            st.nextToken();
            int y = (int) st.nval;
            int start = x * l + y;
            st.nextToken();
            x = (int) st.nval;
            st.nextToken();
            y = (int) st.nval;
            int end = x * l + y;

            if (start == end) {
                System.out.println(0);
                continue;
            }

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                x = curr / l;
                y = curr % l;
                boolean flag = false;
                for (int[] direction : directions) {
                    int xx = x + direction[0];
                    int yy = y + direction[1];
                    int a = xx * l + yy;
                    if (xx >= 0 && xx < l && yy >= 0 && yy < l && grid[a] == 0) {
                        if (a == end) {
                            flag = true;
                            System.out.println(grid[curr] + 1);
                            break;
                        }
                        grid[a] = grid[curr] + 1;
                        queue.offer(a);
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
    }
}
