import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName 走迷宫
 * @Author 11214
 * @Date 2020/4/4
 * @Description BFS
 */
public class Solution14608 {
    private static class Pair {
        private int x;
        private int y;
        private int step;
        private int state;

        public Pair(int x, int y, int step, int state) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        boolean[][][] visited = new boolean[1005][1005][3];
        char[][] quiz = new char[1005][1005];
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        while (sum-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int r = scanner.nextInt() - 1;
            int c = scanner.nextInt() - 1;
            for (int i = 0; i < n; i++) {
                String line = scanner.next();
                for (int j = 0; j < m; j++) {
                    quiz[i][j] = line.charAt(j);
                    for (int k = 0; k < 3; k++) {
                        visited[i][j][k] = false;
                    }
                }
            }
            if (quiz[r][c] == '*') {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            Queue<Pair> queue = new ArrayDeque<>();
            queue.add(new Pair(0, 0, 0, 0));
            visited[0][0][0] = true;
            boolean solved = false;
            while (!queue.isEmpty()) {
                Pair front = queue.poll();
                if (front.x == r && front.y == c) {
                    System.out.println(front.step * 2);
                    solved = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int x = front.x + direction[i][0];
                    int y = front.y + direction[i][1];
                    if (x >= 0 && x < n && y >= 0 && y < m && quiz[x][y] != '*') {
                        if (quiz[x][y] == '.' && !visited[x][y][front.state]) {
                            visited[x][y][front.state] = true;
                            queue.add(new Pair(x, y, front.step + 1, front.state));
                        } else if (quiz[x][y] == 'M' && front.state != 2 && !visited[x][y][front.state]) {
                            visited[x][y][front.state] = true;
                            queue.add(new Pair(x, y, front.step + 1, 1));
                        } else if (quiz[x][y] == 'F' && front.state != 1 && !visited[x][y][front.state]) {
                            visited[x][y][front.state] = true;
                            queue.add(new Pair(x, y, front.step + 1, 2));
                        }
                    }
                }
            }
            if (!solved) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
