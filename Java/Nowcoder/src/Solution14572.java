import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName 走出迷宫
 * @Author 11214
 * @Date 2020/4/3
 * @Description DFS
 */
public class Solution14572 {
    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n;
    private static int m;
    private static char[][] quiz;
    private static Point start;
    private static Point end;
    private static boolean flag;
    private static boolean[][] walked;
    private static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static void dfs(Point current) {
        if (current.x == end.x && current.y == end.y) {
            flag = true;
            return;
        }
        if (flag) return;

        for (int i = 0; i < 4; i++) {
            int x = current.x + directions[i][0];
            int y = current.y + directions[i][1];
            if (x >= 0 && x < n && y >= 0 && y < m && !walked[x][y] && quiz[x][y] != '#') {
                walked[x][y] = true;
                dfs(new Point(x, y));
                //walked[x][y] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        quiz = new char[500][500];
        walked = new boolean[500][500];
        while (scanner.hasNext()) {
            flag = false;
            for (boolean[] booleans : walked) {
                Arrays.fill(booleans, false);
            }
            n = scanner.nextInt();
            m = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String line = scanner.next();
                for (int j = 0; j < m; j++) {
                    quiz[i][j] = line.charAt(j);
                    if (quiz[i][j] == 'S') {
                        start = new Point(i, j);
                    } else if (quiz[i][j] == 'E') {
                        end = new Point(i, j);
                    }
                }
            }
            walked[start.x][start.y] = true;
            dfs(start);
            walked[start.x][start.y] = false;

            if (flag) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
