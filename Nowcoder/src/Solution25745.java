import java.util.Scanner;

/**
 * @ClassName Solution25745
 * @Author 11214
 * @Date 2020/4/27
 * @Description TODO
 */
public class Solution25745 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] dp = new int[c + 10];
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            for (int j = w; j <= c; j++) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        System.out.println(dp[c]);
    }
}
