import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
NO576 出界的路径数
给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。
但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
 */
public class Solution576 {
    public int findPaths(int m, int n, int N, int i, int j) {
        int ans = 0;
        int mod = 1000000007;
        int[][][] ground = new int[N][m + 2][n + 2];
        if (N == 0) return 0;
        ground[0][i + 1][j + 1] = 1;
        if (i == 0) ans += 1;
        if (i == m - 1) ans += 1;
        if (j == 0) ans += 1;
        if (j == n - 1) ans += 1;

        for (int k = 1; k < N; k++) {
            for (int row = 1; row <= m; row++) {
                for (int col = 1; col <= n; col++) {
                    ground[k][row][col] += ground[k - 1][row - 1][col];
                    ground[k][row][col] %= mod;
                    ground[k][row][col] += ground[k - 1][row + 1][col];
                    ground[k][row][col] %= mod;
                    ground[k][row][col] += ground[k - 1][row][col - 1];
                    ground[k][row][col] %= mod;
                    ground[k][row][col] += ground[k - 1][row][col + 1];
                    ground[k][row][col] %= mod;
                    if (row == 1) {
                        ans += ground[k][row][col];
                        ans %= mod;
                    }
                    if (row == m) {
                        ans += ground[k][row][col];
                        ans %= mod;
                    }
                    if (col == 1) {
                        ans += ground[k][row][col];
                        ans %= mod;
                    }
                    if (col == n) {
                        ans += ground[k][row][col];
                        ans %= mod;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution576().findPaths(1, 2, 4, 0, 0));
        System.out.println();
    }
}
