import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName 迷宫
 * @Author 11214
 * @Date 2020/4/4
 * @Description BFS
 */
public class Solution15136 {
    private static class Method {
        private int x;
        private int y;
        private int step;
        private int status;

        public Method(int x, int y, int step, int status) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.status = status;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] quiz = new char[n][m];
        boolean[][][] walked = new boolean[n][m][2];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < m; j++) {
                quiz[i][j] = line.charAt(j);
                if (quiz[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        walked[startX][startY][0] = true;
        Queue<Method> queue = new ArrayDeque<>();
        queue.add(new Method(startX, startY, 0, 0));
        while (!queue.isEmpty()) {
            Method method = queue.poll();
            if (quiz[method.x][method.y] == 'E') {
                System.out.println(method.step);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int x = method.x + directions[i][0];
                int y = method.y + directions[i][1];
                if (x >= 0 && x < n && y >= 0 && y < m && quiz[x][y] != 'W' && !walked[x][y][method.status]) {
                    if (quiz[x][y] == 'K') {
                        walked[x][y][method.status] = true;
                        queue.add(new Method(x, y, method.step + 1, 1));
                    } else if (quiz[x][y] == 'D') {
                        if (method.status == 1) {
                            walked[x][y][1] = true;
                            queue.add(new Method(x, y, method.step + 1, 1));
                        }
                    } else {
                        walked[x][y][method.status] = true;
                        queue.add(new Method(x, y, method.step + 1, method.status));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
