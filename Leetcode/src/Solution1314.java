/*
NO1314 矩阵区域和
给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 

i - K <= r <= i + K, j - K <= c <= j + K 
(r, c) 在矩阵内。
 */
public class Solution1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        int[][] matrix = new int[n + K * 2][m + K * 2];
        for (int i = 0; i < n; i++) {
            System.arraycopy(mat[i], 0, matrix[i + K], K, m);
        }
        int sum = 0;
        for (int i = 0; i < K * 2 + 1; i++) {
            for (int j = 0; j < K * 2 + 1; j++) {
                sum += matrix[i][j];
            }
        }
        ans[0][0] = sum;

        for (int j = K + 1; j < m + K; j++) {
            int sub = 0;
            int add = 0;
            for (int i = 0; i < K * 2 + 1; i++) {
                sub += matrix[i][j - K - 1];
                add += matrix[i][j + K];
            }
            ans[0][j - K] = ans[0][j - K - 1] - sub + add;
        }

        for (int j = K; j < m + K; j++) {
            for (int i = K + 1; i < n + K; i++) {
                int sub = 0;
                int add = 0;
                for (int k = j - K; k <= j + K; k++) {
                    sub += matrix[i - K - 1][k];
                    add += matrix[i + K][k];
                }
                ans[i - K][j - K] = ans[i - K - 1][j - K] - sub + add;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] ints = new Solution1314().matrixBlockSum(x, 2);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
