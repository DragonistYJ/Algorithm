package interview;

/**
 * @ClassName Solution08_11
 * @Author 11214
 * @Date 2020/4/28
 * @Description TODO
 */
public class Solution08_11 {
    public int waysToChange(int n) {
        int mod = 1000000007;
        int[] prices = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int k = 0; k < 4; k++) {
            for (int i = prices[k]; i <= n; i++) {
                dp[i] = (dp[i - prices[k]] + dp[i]) % mod;
            }
        }
        return dp[n];
    }
}
