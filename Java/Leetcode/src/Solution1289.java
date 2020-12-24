import java.util.Arrays;

/*
NO1289 下降路径最小和2
给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
请你返回非零偏移下降路径数字和的最小值。
 */
public class Solution1289 {
    public int minFallingPathSum(int[][] arr) {
        int len = arr.length;
        int[][] dp = new int[len + 1][len];

        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < len; k++) {
                    if (j == k) continue;
                    dp[i][j] = Math.min(dp[i][j], arr[i - 1][k] + dp[i - 1][k]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            ans = Math.min(ans, dp[len][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution1289().minFallingPathSum(x));
    }
}
