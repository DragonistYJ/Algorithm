import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Solution19909
 * @Author 11214
 * @Date 2020/4/26
 * @Description TODO
 */
public class Solution19909 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        int len = line.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], len * 2);
            dp[i][i] = 1;
        }

        for (int gap = 2; gap <= len; gap++) {
            for (int l = 0; l <= len - gap; l++) {
                int r = l + gap - 1;
                if (line.charAt(l) == line.charAt(r)) {
                    dp[l][r] = Math.min(dp[l][r - 1], dp[l + 1][r]);
                } else {
                    for (int i = l; i < r; i++) {
                        dp[l][r] = Math.min(dp[l][r], dp[l][i] + dp[i + 1][r]);
                    }
                }
            }
        }

        System.out.println(dp[0][len - 1]);
    }
}
