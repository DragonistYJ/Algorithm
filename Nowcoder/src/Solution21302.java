import java.util.Scanner;

/**
 * @ClassName Solution21302
 * @Author 11214
 * @Date 2020/4/26
 * @Description TODO
 */
public class Solution21302 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        int n = line.length();
        int[] nums = new int[n + 1];
        long mod = 1000000000 + 7;
        for (int i = 0; i < n; i++) {
            nums[i + 1] = line.charAt(i) - '0';
        }
        long[][] dp = new long[n + 1][3];
        for (int i = 1; i <= n; i++) {
            if (nums[i] % 3 == 0) {
                dp[i][0] = (dp[i - 1][0] * 2 + 1) % mod;
                dp[i][1] = (dp[i - 1][1] * 2) % mod;
                dp[i][2] = (dp[i - 1][2] * 2) % mod;
            } else if (nums[i] % 3 == 1) {
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
                dp[i][1] = (dp[i - 1][1] + dp[i - 1][0] + 1) % mod;
                dp[i][2] = (dp[i - 1][2] + dp[i - 1][1]) % mod;
            } else {
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
                dp[i][1] = (dp[i - 1][1] + dp[i - 1][2]) % mod;
                dp[i][2] = (dp[i - 1][2] + dp[i - 1][0] + 1) % mod;
            }
        }
        System.out.println(dp[n][0] % mod);
    }
}
