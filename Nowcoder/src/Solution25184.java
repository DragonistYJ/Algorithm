import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Solution25184
 * @Author 11214
 * @Date 2020/4/21
 * @Description TODO
 */
public class Solution25184 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n;
        int t;
        while (k-- > 0) {
            n = scanner.nextInt();
            t = scanner.nextInt();
            int[] a = new int[n];
            int[] dp = new int[t];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);
            for (int i = 0; i < n - 1; i++) {
                for (int j = t - 1; j >= a[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - a[i]] + a[i]);
                }
            }
            System.out.println(dp[t - 1] + a[n - 1]);
        }
    }
}
