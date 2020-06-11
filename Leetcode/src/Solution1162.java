import sun.applet.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Solution1162
 * @Author 11214
 * @Date 2020/6/10
 * @Description 地图分析
 * 你现在手里有一份大小为 N x N 的「地图」（网格） grid，上面的每个「区域」（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 */
public class Solution1162 {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j] == 1 ? 0 : n * n;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                int top = i == 0 ? n * n : dp[i - 1][j];
                int left = j == 0 ? n * n : dp[i][j - 1];
                dp[i][j] = Math.min(dp[i][j], Math.min(top, left) + 1);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) continue;
                int down = i == n - 1 ? n * n : dp[i + 1][j];
                int right = j == n - 1 ? n * n : dp[i][j + 1];
                dp[i][j] = Math.min(dp[i][j], Math.min(down, right) + 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                ans = Math.max(ans, dp[i][j]);
            }
        }

        if (ans == 0 || ans >= n * n) return -1;
        else return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(new Solution1162().maxDistance(grid));
    }
}
