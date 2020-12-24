import java.util.Arrays;
import java.util.Scanner;

/**
 * @problem 两条公路
 * @category 暴力枚举
 * @author 11214
 * @description 平面上有n个点,现在你需要建造两条路，一条是斜率为1, 另一条斜率为-1 你的任务是让这两条路经过尽可能多的点 求最多经过几个点
 */
public class Solution21670 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] xAxis = new int[n];
		int[] yAxis = new int[n];
		int[] k1 = new int[2000];
		int[] k2 = new int[2000];
		int[][] k3 = new int[2000][2000];

		for (int i = 0; i < n; i++) {
			xAxis[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			yAxis[i] = scanner.nextInt();
		}

		for (int i = 0; i < n; i++) {
			k1[xAxis[i] + yAxis[i]] += 1;
			k2[xAxis[i] - yAxis[i] + 999] += 1;
			k3[xAxis[i] + yAxis[i]][xAxis[i] - yAxis[i] + 999] += 1;
		}

		int ans = 0;
		for (int i = 0; i < 2000; i++) {
			for (int j = 0; j < 2000; j++) {
				ans = Math.max(ans, k1[i] + k2[j] - k3[i][j]);
			}
		}
		System.out.println(ans);
	}
}
