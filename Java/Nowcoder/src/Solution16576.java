import java.util.Scanner;

/**
 * @problem 摆花
 * @category 动态规划
 * @author 11214
 * @description 小明的花店新开张，为了吸引顾客，他想在花店的门口摆上一排花，共m 盆。通过调查顾客的喜好，小明列出了顾客最喜欢的n 种花，
 *              从1到n标号。为了在门口展出更多种花，规定第i 种花不能超过ai
 *              盆，摆花时同一种花放在一起，且不同种类的花需按标号的从小到大的顺序依次摆列。 试编程计算，一共有多少种不同的摆花方案。
 */
public class Solution16576 {
	public static void main(String[] args) {
		int mod = 1000007;
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = scanner.nextInt();
		}
		int[][] dp = new int[n + 1][m + 1];

		dp[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= m; j++) {
				for (int k = Math.max(0, j - a[i]); k <= j; k++) {
					dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod;
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}
