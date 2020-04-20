import java.util.ArrayList;
import java.util.List;

/*
NO51 N皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] row = new int[n];
        int[] rightCross = new int[n * 2 - 1];
        int[] leftCross = new int[n * 2 - 1];
        int[] rowPosition = new int[n];
        dfs(ans, row, rightCross, leftCross, rowPosition, 0, n);
        return ans;
    }

    private void dfs(List<List<String>> ans, int[] row, int[] rightCross, int[] leftCross, int[] rowPosition, int n, int N) {
        if (n == N) {
            makeAnswer(ans, rowPosition, N);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (row[i] == 0 && rightCross[i - n + N - 1] == 0 && leftCross[n + i] == 0) {
                row[i] = 1;
                rightCross[i - n + N - 1] = 1;
                leftCross[n + i] = 1;
                rowPosition[n] = i;
                dfs(ans, row, rightCross, leftCross, rowPosition, n + 1, N);
                rowPosition[n] = 0;
                leftCross[n + i] = 0;
                rightCross[i - n + N - 1] = 0;
                row[i] = 0;
            }
        }
    }

    private void makeAnswer(List<List<String>> ans, int[] rowPosition, int N) {
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if (j == rowPosition[i]) {
                    s.append("Q");
                } else {
                    s.append(".");
                }
            }
            tmp.add(s.toString());
        }
        ans.add(tmp);
    }

    public static void main(String[] args) {
        System.out.println(new Solution51().solveNQueens(4));
    }
}
