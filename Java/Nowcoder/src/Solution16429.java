import java.util.Scanner;

/**
 * @ClassName 组合数问题
 * @Author 11214
 * @Date 2020/4/4
 * @Description 排列组合数学
 */
public class Solution16429 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] combs = new int[2005][2005];
        combs[1][0] = 1;
        combs[1][1] = 1;
        for (int i = 2; i <= 2000; i++) {
            combs[i][0] = 1;
            for (int j = 1; j < i; j++) {
                combs[i][j] = (combs[i - 1][j] + combs[i - 1][j - 1]) % k;
            }
            combs[i][i] = 1;
        }

        int[][] ans = new int[2005][2005];
        ans[1][0] = 0;
        ans[1][1] = 0;
        for (int i = 2; i <= 2000; i++) {
            ans[i][0] = 0;
            for (int j = 1; j < i; j++) {
                ans[i][j] = ans[i][j - 1] + ans[i - 1][j] - ans[i - 1][j - 1];
                if (combs[i][j] == 0) ans[i][j] += 1;
            }
            ans[i][i] = ans[i][i - 1];
        }

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(ans[n][Math.min(n, m)]);
        }
    }
}
