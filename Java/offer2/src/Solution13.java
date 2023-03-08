/**
 * @author 11214
 * @since 2023/3/8 16:57
 */
public class Solution13 {
    private static class NumMatrix {
        private long[][] matrix;

        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            this.matrix = new long[n + 2][m + 2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    this.matrix[i + 1][j + 1] = matrix[i][j] + this.matrix[i][j + 1] + this.matrix[i + 1][j] - this.matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1 += 1;
            col1 += 1;
            row2 += 1;
            col2 += 1;
            return (int) (this.matrix[row2][col2]
                    - this.matrix[row1 - 1][col2]
                    - this.matrix[row2][col1 - 1]
                    + this.matrix[row1 - 1][col1 - 1]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }
}
