package interview;

/**
 * @ClassName Solution47
 * @Author 11214
 * @Date 2020/4/12
 * @Description TODO
 */
public class Solution47 {
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] sum = new int[n][m];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sum[i][j] = grid[i][j] + Math.max(sum[i - 1][j], sum[i][j - 1]);
            }
        }
        return sum[n - 1][m - 1];
    }
}
