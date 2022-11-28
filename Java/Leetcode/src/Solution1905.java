/**
 * @author 11214
 * @since 2022/11/28 9:57
 * <p>
 * 给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。
 * 一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
 * 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
 * 请你返回 grid2 中 子岛屿 的 数目 。
 */
public class Solution1905 {
    private int n;
    private int m;
    private boolean[][] visited;
    private final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean travel(int x, int y, int[][] grid1, int[][] grid2) {
        boolean ans = grid1[x][y] == 1;
        visited[x][y] = true;

        for (int[] direction : directions) {
            int xx = x + direction[0];
            int yy = y + direction[1];
            if (xx >= 0 && xx < n && yy >= 0 && yy < m && !visited[xx][yy] && grid2[xx][yy] == 1) {
                if (!travel(xx, yy, grid1, grid2)) {
                    ans = false;
                }
            }
        }

        return ans;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;
        visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid2[i][j] == 1) {
                    if (travel(i, j, grid1, grid2)) {
                        ans += 1;
                    }
                }
            }
        }
        return ans;
    }
}
