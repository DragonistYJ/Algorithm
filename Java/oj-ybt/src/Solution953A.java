import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/17 10:03
 */
public class Solution953A {
    public static void main(String[] args) {
        int[][] directions = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int[][] gs = {{0, 0}, {-1, -1}, {0, -1}, {-1, 0}};
        char[] cs = {'\\', '\\', '/', '/'};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] units = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                units[i][j] = s.charAt(j);
            }
        }
        int[][] steps = new int[n + 1][m + 1];
        for (int[] step : steps) {
            Arrays.fill(step, n * m);
        }
        steps[0][0] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int x = curr / (m + 1);
            int y = curr % (m + 1);
            for (int i = 0; i < 4; i++) {
                int[] direction = directions[i];
                int xx = x + direction[0];
                int yy = y + direction[1];
                int[] g = gs[i];
                int gx = x + g[0];
                int gy = y + g[1];
                if (xx >= 0 && xx <= n && yy >= 0 && yy <= m && gx >= 0 && gx < n && gy >= 0 && gy < m) {
                    int step = units[gx][gy] == cs[i] ? 0 : 1;
                    if (steps[x][y] + step < steps[xx][yy]) {
                        steps[xx][yy] = steps[x][y] + step;
                        queue.offer(xx * (m + 1) + yy);
                    }
                }
            }
        }
        if (steps[n][m] == n * m) {
            System.out.println("NO SOLUTION");
        } else {
            System.out.println(steps[n][m]);
        }
    }
}
