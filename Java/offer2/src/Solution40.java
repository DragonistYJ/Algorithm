import java.util.ArrayDeque;

/**
 * @author 11214
 * @since 2023/3/31 17:28
 */
public class Solution40 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        ArrayDeque<int[]> deque = new ArrayDeque<>(n);
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int height = i == n ? 0 : heights[i];
            int[] pair = {height, i};
            while (true) {
                if (deque.isEmpty()) {
                    deque.offerLast(pair);
                    break;
                }
                int[] last = deque.peekLast();
                if (height <= last[0]) {
                    deque.pollLast();
                    pair[1] = last[1];
                    ans = Math.max(ans, (i - last[1]) * last[0]);
                } else {
                    deque.offerLast(pair);
                    break;
                }
            }
        }
        return ans;
    }

    public int maximalRectangle(String[] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = matrix[i].charAt(j) - '0';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[j][i] != 0) {
                    mat[j][i] = mat[j - 1][i] + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int res = largestRectangleArea(mat[i]);
            ans = Math.max(ans, res);
        }
        return ans;
    }
}
