/**
 * @ClassName Solution1020
 * @Author 11214
 * @Date 2020/6/7
 * @Description 飞地的数量
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 */
public class Solution1020 {
    private final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int n;
    private int m;

    private void dfs(int x, int y, boolean[][] connectable, int[][] A) {
        for (int i = 0; i < 4; i++) {
            int xx = x + directions[i][0];
            int yy = y + directions[i][1];
            if (xx >= 0 && xx < n && yy >= 0 && yy < m && A[xx][yy] == 1 && !connectable[xx][yy]) {
                connectable[xx][yy] = true;
                dfs(xx, yy, connectable, A);
            }
        }
    }

    public int numEnclaves(int[][] A) {
        n = A.length;
        m = A[0].length;
        boolean[][] connectable = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (A[i][0] == 1 && !connectable[i][0]) {
                connectable[i][0] = true;
                dfs(i, 0, connectable, A);
            }
            if (A[i][m - 1] == 1 && !connectable[i][m - 1]) {
                connectable[i][m - 1] = true;
                dfs(i, m - 1, connectable, A);
            }
        }
        for (int i = 0; i < m; i++) {
            if (A[0][i] == 1 && !connectable[0][i]) {
                connectable[0][i] = true;
                dfs(0, i, connectable, A);
            }
            if (A[n - 1][i] == 1 && !connectable[n - 1][i]) {
                connectable[n - 1][i] = true;
                dfs(n - 1, i, connectable, A);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1 && !connectable[i][j]) ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        System.out.println(new Solution1020().numEnclaves(A));
    }
}
