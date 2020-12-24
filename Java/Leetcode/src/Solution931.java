/*
NO931 下降路径最小和
给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 */
public class Solution931 {
    public int minFallingPathSum(int[][] A) {
        int len = A.length;
        int[][] dp = new int[len + 1][len];

        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < len; j++) {
                int way1;
                int way2;
                int way3;
                if (j - 1 >= 0) {
                    way1 = dp[i - 1][j - 1] + A[i - 1][j - 1];
                } else {
                    way1 = Integer.MAX_VALUE;
                }
                way2 = dp[i - 1][j] + A[i - 1][j];
                if (j + 1 < len) {
                    way3 = dp[i - 1][j + 1] + A[i - 1][j + 1];
                } else {
                    way3 = Integer.MAX_VALUE;
                }
                dp[i][j] = Math.min(way1, Math.min(way2, way3));
            }
        }

        int ans = dp[len][0];
        for (int i = 1; i < len; i++) {
            ans = Math.min(ans, dp[len][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution931().minFallingPathSum(x));
    }
}
