/*
NO85 最大矩形
给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int[][] row = new int[m][n];
        int[][] col = new int[m][n];
        int ans = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i - 1][j - 1] == '1' && matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1' && matrix[i][j] == '1') {
                    row[i][j] = row[i - 1][j] + 1;
                    col[i][j] = col[i][j - 1] + 1;
                    ans = Math.max(ans, (row[i][j] + 1) * (col[i][j] + 1));
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    tmp += 1;
                } else {
                    ans = Math.max(ans, tmp);
                    tmp = 0;
                }
            }
            ans = Math.max(ans, tmp);
        }
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] == '1') {
                    tmp += 1;
                } else {
                    ans = Math.max(ans, tmp);
                    tmp = 0;
                }
            }
            ans = Math.max(ans, tmp);
        }

        return ans;
    }

    public static void main(String[] args) {
        char[][] x = {
                {'0', '1', '1', '0', '1'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution85().maximalRectangle(x));
    }
}
