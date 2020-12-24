package interview;

/**
 * @ClassName Solution14_1
 * @Author 11214
 * @Date 2020/4/12
 * @Description TODO
 */
public class Solution14_1 {
    public int cuttingRope(int n) {
        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution14_1().cuttingRope(10));
    }
}
