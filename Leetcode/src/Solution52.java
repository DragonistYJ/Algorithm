import java.util.List;

/*
NO52 N皇后2
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 */
public class Solution52 {
    public int totalNQueens(int n) {
        int[] row = new int[n];
        int[] rightCross = new int[n * 2 - 1];
        int[] leftCross = new int[n * 2 - 1];
        int[] rowPosition = new int[n];
        return dfs(row, rightCross, leftCross, rowPosition, 0, n);
    }

    private int dfs(int[] row, int[] rightCross, int[] leftCross, int[] rowPosition, int n, int N) {
        if (n == N) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (row[i] == 0 && rightCross[i - n + N - 1] == 0 && leftCross[n + i] == 0) {
                row[i] = 1;
                rightCross[i - n + N - 1] = 1;
                leftCross[n + i] = 1;
                rowPosition[n] = i;
                sum += dfs(row, rightCross, leftCross, rowPosition, n + 1, N);
                rowPosition[n] = 0;
                leftCross[n + i] = 0;
                rightCross[i - n + N - 1] = 0;
                row[i] = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution52().totalNQueens(4));
    }
}
