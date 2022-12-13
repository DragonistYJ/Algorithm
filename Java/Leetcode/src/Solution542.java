import java.util.Arrays;

/**
 * @author 11214
 * @since 2022/12/13 10:37
 * <p>
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 */
public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != 0) {
                    ans[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i + 1 < n) {
                    ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] + 1);
                }
                if (j + 1 < m) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(new Solution542().updateMatrix(mat)));
    }
}
