/**
 * 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class Solution718 {
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        int ans = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i] == B[j]) dp[i + 1][j + 1] = dp[i][j] + 1;
                ans = Math.max(ans, dp[i + 1][j + 1]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {0, 0, 0, 0, 0};
        int[] B = {0, 0, 0, 0, 0};
        System.out.println(new Solution718().findLength(A, B));
    }
}
