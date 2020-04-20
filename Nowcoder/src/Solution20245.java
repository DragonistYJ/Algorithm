import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @problem 繁忙的都市
 * @author 11214
 * @category 最小生成树
 * @description 城市C是一个非常繁忙的大都市，城市中的道路十分的拥挤，于是市长决定对其中的道路进行改造。 城市C的道
 *              路是这样分布的：城市中有n个交叉路口，有些交叉路口之间有道路相连，两个交叉路口之间最多有一条道路相连接。这些道路是双向的，且把所有的交叉路口直接或间接的连接起来了。每条道路都有一个分值，分值越小表示这个道路越繁忙，越需要进行改造。但是市政府的资金有限，市长希望进行改造的道路越少越好，于是他提出下面的
 *              要求： 1． 改造的那些道路能够把所有的交叉路口直接或间接的连通起来。 2． 在满足要求1的情况下，改造的道路尽量少。 3．
 *              在满足要求1、2的情况下，改造的那些道路中分值最大的道路分值尽量小。
 *              任务：作为市规划局的你，应当作出最佳的决策，选择那些道路应当被修建。
 */
public class Solution20245 {
	private static class Edge {
		private int u;
		private int v;
		private int w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	private static int find(int n) {
		if (group[n] == n)
			return n;
		else {
			group[n] = find(group[n]);
			return group[n];
		}
	}

	private static void merge(int n1, int n2) {
		int g1 = find(n1);
		int g2 = find(n2);
		if (g1 != g2) {
			group[g1] = g2;
		}
	}

	private static int[] group;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		List<Edge> list = new ArrayList<>(m);
		for (int i = 0; i < m; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			list.add(new Edge(u, v, w));
		}
		list.sort((e1, e2) -> {
			return Integer.compare(e1.w, e2.w);
		});
		group = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			group[i] = i;
		}
		int max = 0;
		for (int i = 0; i < m; i++) {
			Edge edge = list.get(i);
			if (find(edge.u) != find(edge.v)) {
				max = Math.max(max, edge.w);
				merge(edge.u, edge.v);
			}
		}
		System.out.println((n - 1) + " " + max);
		scanner.close();
	}
}
