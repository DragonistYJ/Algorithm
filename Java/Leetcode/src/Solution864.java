import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
NO864 获取所有钥匙的最短路径
给定一个二维网格 grid。 "." 代表一个空房间， "#" 代表一堵墙， "@" 是起点，（"a", "b", ...）代表钥匙，（"A", "B", ...）代表锁。
我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
假设 K 为钥匙/锁的个数，且满足 1 <= K <= 6，字母表中的前 K 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列
返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
 */
public class Solution864 {
    private boolean isKey(char c) {
        return c >= 'a' && c <= 'f';
    }

    private boolean isLock(char c) {
        return c >= 'A' && c <= 'F';
    }

    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        boolean[][][] walked = new boolean[n][m][64];
        int keys = 0;
        int startX = 0;
        int startY = 0;
        char[][] graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = grid[i].charAt(j);
                if (isKey(graph[i][j])) keys += 1;
                if (graph[i][j] == '@') {
                    startX = i;
                    startY = j;
                    graph[i][j] = '.';
                }
            }
        }
        int aimState = (int) Math.pow(2, keys) - 1;

        List<Step> steps = new LinkedList<>();
        steps.add(new Step(0, 0, startX, startY));
        walked[startX][startY][0] = true;
        while (!steps.isEmpty()) {
            Step step = steps.get(0);
            steps.remove(0);
            int x = step.posX;
            int y = step.posY;
            int state = step.state;

            if (state == aimState) return step.steps;
            if (x > 0 && graph[x - 1][y] != '#' && !walked[x - 1][y][state]) {
                walk(graph, walked, step, steps, x - 1, y);
            }
            if (x < n - 1 && graph[x + 1][y] != '#' && !walked[x + 1][y][state]) {
                walk(graph, walked, step, steps, x + 1, y);
            }
            if (y > 0 && graph[x][y - 1] != '#' && !walked[x][y - 1][state]) {
                walk(graph, walked, step, steps, x, y - 1);
            }
            if (y < m - 1 && graph[x][y + 1] != '#' && !walked[x][y + 1][state]) {
                walk(graph, walked, step, steps, x, y + 1);
            }
        }
        return -1;
    }

    private void walk(char[][] graph, boolean[][][] walked, Step step, List<Step> steps, int x, int y) {
        int state = step.state;

        if (graph[x][y] == '.') {
            steps.add(new Step(state, step.steps + 1, x, y));
            walked[x][y][state] = true;
        } else if (isKey(graph[x][y])) {
            int newState = state | (1 << (graph[x][y] - 'a'));
            steps.add(new Step(newState, step.steps + 1, x, y));
            walked[x][y][newState] = true;
        } else if (isLock(graph[x][y]) && (state & (1 << (graph[x][y] - 'A'))) != 0) {
            steps.add(new Step(state, step.steps + 1, x, y));
            walked[x][y][state] = true;
        }
    }

    private class Step {
        public int state;
        public int steps;
        public int posX;
        public int posY;

        public Step(int state, int steps, int posX, int posY) {
            this.state = state;
            this.steps = steps;
            this.posX = posX;
            this.posY = posY;
        }
    }

    public static void main(String[] args) {
        String[] g = {"b", "A", "a", "@", "B"};
        System.out.println(new Solution864().shortestPathAllKeys(g));
    }
}
