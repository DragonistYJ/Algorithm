package offer;

/**
 * @author 11214
 * @since 2022/12/5 16:59
 */
public class Solution99 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] matrix = new int[n][m];

        matrix[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            matrix[i][0] = grid[i][0] + matrix[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            matrix[0][i] = grid[0][i] + matrix[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                matrix[i][j] = grid[i][j] + Math.min(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }

        return matrix[n - 1][m - 1];
    }
}
