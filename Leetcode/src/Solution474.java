/**
 * @ClassName Solution474
 * @Author 11214
 * @Date 2020/4/28
 * @Description TODO
 */
public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] zeros = new int[len];
        int[] ones = new int[len];
        for (int i = 0; i < len; i++) {
            int zero = 0;
            int one = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') zero += 1;
                else one += 1;
            }
            zeros[i] = zero;
            ones[i] = one;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0; k < len; k++) {
            for (int i = m - zeros[k]; i >= 0; i--) {
                for (int j = n - ones[k]; j >= 0; j--) {
                    dp[i + zeros[k]][j + ones[k]] = Math.max(dp[i + zeros[k]][j + ones[k]], dp[i][j] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
