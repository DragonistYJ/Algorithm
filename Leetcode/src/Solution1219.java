/**
 * 黄金矿工
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 */
public class Solution1219 {
    private int ans;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int n;
    private int m;

    private void dfs(int[][] grid, boolean[][] visited, int sum, int x, int y) {
        ans = Math.max(ans, sum);

        for (int i = 0; i < 4; i++) {
            int xx = x + directions[i][0];
            int yy = y + directions[i][1];
            if (xx >= 0 && xx < n && yy >= 0 && yy < m && grid[xx][yy] != 0 && !visited[xx][yy]) {
                visited[xx][yy] = true;
                dfs(grid, visited, sum + grid[xx][yy], xx, yy);
                visited[xx][yy] = false;
            }
        }
    }

    public int getMaximumGold(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        ans = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    visited[i][j] = true;
                    dfs(grid, visited, grid[i][j], i, j);
                    visited[i][j] = false;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}};
        System.out.println(new Solution1219().getMaximumGold(grid));
    }
}
