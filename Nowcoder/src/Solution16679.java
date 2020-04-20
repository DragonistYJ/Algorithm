import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @problem 神经网络
 * @author 11214
 * @category 图论
 */
public class Solution16679 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int p = scanner.nextInt();
		int[] c = new int[n];
		int[] u = new int[n];
		int[] inDegree = new int[n];
		int[] outDegree = new int[n];
		int[][] weights = new int[n][n];
		boolean[][] connected = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			c[i] = scanner.nextInt();
			u[i] = scanner.nextInt();
		}
		for (int i = 0; i < p; i++) {
			int s = scanner.nextInt() - 1;
			int t = scanner.nextInt() - 1;
			int w = scanner.nextInt();
			weights[s][t] = w;
			connected[s][t] = true;
			outDegree[s] += 1;
			inDegree[t] += 1;
		}

		Set<Integer> layer = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (inDegree[i] == 0)
				layer.add(i);
		}
		while (!layer.isEmpty()) {
			Set<Integer> temp = new HashSet<>(layer);
			layer.clear();
			for (Integer cell : temp) {
				if (c[cell] > 0) {
					for (int i = 0; i < n; i++) {
						if (connected[cell][i]) {
							c[i] = c[i] + c[cell] * weights[cell][i];
							layer.add(i);
						}
					}
				}
			}
			for (Integer cell : layer) {
				c[cell] = c[cell] - u[cell];
			}
		}

		boolean flag = true;
		for (int i = 0; i < n; i++) {
			if (outDegree[i] == 0 && c[i] != 0) {
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.println("NULL");
		} else {
			for (int i = 0; i < n; i++) {
				if (outDegree[i] == 0 && c[i] > 0) {
					System.out.println((i+1) + " " + c[i]);
				}
			}
		}

		scanner.close();
	}
}
