import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName Solution329
 * @Author 11214
 * @Date 2020/4/18
 * @Description TODO
 */
public class Solution329 {
    private class Pair {
        private int x;
        private int y;
        private int value;

        public Pair() {
        }

        public Pair(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public int longestIncreasingPath(int[][] matrix) {
        Queue<Pair> queue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                queue.offer(new Pair(i, j, matrix[i][j]));
            }
        }
        int[][] ans = new int[n][m];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ret = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = pair.x + directions[i][0];
                int y = pair.y + directions[i][1];
                if (x >= 0 && x < n && y >= 0 && y < m && matrix[pair.x][pair.y] < matrix[x][y]) {
                    ans[pair.x][pair.y] = Math.max(ans[pair.x][pair.y], ans[x][y] + 1);
                    ret = Math.max(ret, ans[pair.x][pair.y]);
                }
            }
        }
        return ret + 1;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        System.out.println(new Solution329().longestIncreasingPath(nums));
    }
}
