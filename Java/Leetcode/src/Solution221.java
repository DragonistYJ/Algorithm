/**
 * @author yujian
 * @since 2022/8/14 10:31
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] count = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count[i][j] = matrix[i][j] == '1' ? 1 : 0;
                max = Math.max(count[i][j], max);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (count[i][j] == 0 || count[i - 1][j] == 0 || count[i][j - 1] == 0) {
                    continue;
                }
                if (count[i - 1][j] == count[i][j - 1]) {
                    count[i][j] = Math.min(count[i - 1][j - 1], count[i - 1][j]) + 1;
                } else {
                    count[i][j] = Math.min(count[i - 1][j], count[i][j - 1]) + 1;
                }
                if (count[i][j] > max) {
                    max = count[i][j];
                }
            }
        }
        return max * max;
    }
}
