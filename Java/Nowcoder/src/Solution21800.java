import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @problem 最佳射击
 * @author 11214
 * @category 暴力枚举
 * @description 平面直角坐标系上有一些点，你可以进行0或者若干次操作 每次操作可以将所有的点往某个方向平移
 *              也可以将所有的点绕着(0,0)旋转任意角度
 *              你射击一枪能够射到x轴与y轴上的所有点，你希望经过若干次操作后，射击一枪能击中尽可能多的点，求最多可以击中几个点
 */
public class Solution21800 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			y[i] = scanner.nextInt();
		}

		if (n <= 3) {
			System.out.println(n);
			return;
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				for (int k = 0; k < n; k++) {
					if (i == k || j == k)
						continue;
					int tmp = 3;
					for (int t = 0; t < n; t++) {
						if (t == i || t == j || t == k)
							continue;
						if ((x[t] - x[j]) * (y[j] - y[i]) == ((x[j] - x[i]) * (y[t] - y[j]))) {
							tmp += 1;
						} else if ((y[t] - y[k]) * (y[j] - y[i]) == -((x[t] - x[k]) * (x[j] - x[i]))) {
							tmp +=1;
						}
					}
					ans = Math.max(ans, tmp);
				}
			}
		}
		System.out.println(ans);
	}
}
