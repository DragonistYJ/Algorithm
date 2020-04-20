import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
NO778 水位上升的泳池中游泳
 */
class Solution778_2 {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return grid[o1 / n][o1 % n] - grid[o2 / n][o2 % n];
            }
        });

        int[] dRow = new int[]{-1, 1, 0, 0};
        int[] dColumn = new int[]{0, 0, 1, -1};

        int ans = grid[0][0];
        priorityQueue.offer(0);
        set.add(0);
        while (!priorityQueue.isEmpty()) {
            int tmp = priorityQueue.poll();
            int row = tmp / n;
            int column = tmp % n;
            ans = Math.max(ans, grid[row][column]);
            if (row == n - 1 && column == n - 1) return ans;

            for (int i = 0; i < 4; i++) {
                int r = row + dRow[i];
                int c = column + dColumn[i];
                int k = r * n + c;
                if (r >= 0 && r < n && c >= 0 && c < n && !set.contains(k)) {
                    priorityQueue.offer(k);
                    set.add(k);
                }
            }
        }
        throw null;
    }
}

public class Solution778 {
    private int[][] g;
    private int[][] flag;
    private int n;
    private int ans;

    public void swim(int x, int y, int min) {
        if (min >= ans) return;
        if (x == n - 1 && y == n - 1) {
            ans = Math.min(ans, min);
            return;
        }
        if (y < n - 1 && flag[x][y + 1] == 0) {
            flag[x][y + 1] = 1;
            swim(x, y + 1, Math.max(min, g[x][y + 1]));
            flag[x][y + 1] = 0;
        }
        if (x < n - 1 && flag[x + 1][y] == 0) {
            flag[x + 1][y] = 1;
            swim(x + 1, y, Math.max(min, g[x + 1][y]));
            flag[x + 1][y] = 0;
        }
        if (y > 0 && flag[x][y - 1] == 0) {
            flag[x][y - 1] = 1;
            swim(x, y - 1, Math.max(min, g[x][y - 1]));
            flag[x][y - 1] = 0;
        }
        if (x > 0 && flag[x - 1][y] == 0) {
            flag[x - 1][y] = 1;
            swim(x - 1, y, Math.max(min, g[x - 1][y]));
            flag[x - 1][y] = 0;
        }
    }

    public int swimInWater(int[][] grid) {
        g = grid;
        ans = 100000000;
        n = grid.length;
        flag = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flag[i][j] = 0;
            }
        }
        swim(0, 0, g[0][0]);
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}};
        System.out.println(new Solution778_2().swimInWater(grid));
    }
}