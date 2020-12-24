import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Solution16129
 * @Author 11214
 * @Date 2020/4/26
 * @Description TODO
 */
public class Solution16129 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = scanner.nextInt();
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n * 2);
            dp[i][i] = 1;
        }
        for (int gap = 2; gap <= k; gap++) {
            for (int l = 0; l <= n - gap; l++) {
                int r = l + gap - 1;
                if (colors[l] == colors[r]) {
                    dp[l][r] = Math.min(dp[l][r - 1], dp[l + 1][r]);
                } else {
                    for (int i = l; i < r; i++) {
                        dp[l][r] = Math.min(dp[l][r], dp[l][i] + dp[i + 1][r]);
                    }
                }
            }
        }
        for (int gap = k + 1; gap <= n; gap++) {
            for (int l = 0; l <= n - gap; l++) {
                int r = l + gap - 1;
                for (int i = l; i < r; i++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][i] + dp[i + 1][r]);
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}
