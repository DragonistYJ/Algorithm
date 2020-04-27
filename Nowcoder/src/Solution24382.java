import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Solution24382
 * @Author 11214
 * @Date 2020/4/27
 * @Description TODO
 */
public class Solution24382 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] dp = new int[105];
        boolean[] reachable = new boolean[105];
        int[] prices = {1, 5, 10};
        int[] nums = new int[3];
        while (t-- > 0) {
            Arrays.fill(dp, 100000);
            dp[0] = 0;
            Arrays.fill(reachable, false);
            reachable[0] = true;

            int w = scanner.nextInt();
            nums[0] = scanner.nextInt();
            nums[1] = scanner.nextInt();
            nums[2] = scanner.nextInt();
            for (int i = 0; i < 3; i++) {
                for (int j = w - prices[i]; j >= 0; j--) {
                    if (!reachable[j]) continue;
                    for (int k = 1; k <= nums[i]; k++) {
                        if (j + k * prices[i] > w) break;
                        dp[j + k * prices[i]] = Math.min(dp[j + k * prices[i]], dp[j] + k);
                        reachable[j + k * prices[i]] = true;
                    }
                }
            }

            if (!reachable[w]) System.out.println(-1);
            else System.out.println(dp[w]);
        }
    }
}
