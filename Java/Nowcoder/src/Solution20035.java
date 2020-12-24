import java.util.Scanner;

/**
 * @ClassName Solution20035
 * @Author 11214
 * @Date 2020/4/20
 * @Description TODO
 */
public class Solution20035 {
    private static class Rat {
        private int time;
        private int x;
        private int y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Rat[] rats = new Rat[m];
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            Rat rat = new Rat();
            rat.time = scanner.nextInt();
            rat.x = scanner.nextInt();
            rat.y = scanner.nextInt();
            rats[i] = rat;
            dp[i] = 1;
        }

        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                if (Math.abs(rats[i].x - rats[j].x) + Math.abs(rats[i].y - rats[j].y) <= rats[j].time - rats[i].time) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
