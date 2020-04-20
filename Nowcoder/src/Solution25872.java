import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @problem 最小花费
 * @author 11214
 * @category 最小生成树
 * @description Xez是蟹皇堡王国的国王，今天他想在蟹皇堡的n个城市之间建立 （n -
 *              1）条路把这n个城市连接起来，现已知有建立每条路花费的价值为两个城市的收益之和，现在Xez手头很紧，想请你来计算把这n个城市连接起来所花费最小值。
 */
public class Solution25872 {
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
		int[] cost = new int[n];
		for (int i = 0; i < n; i++) {
			cost[i] = scanner.nextInt();
		}
		Queue<Edge> queue = new PriorityQueue<>((e1, e2) -> {
			return Integer.compare(e1.w, e2.w);
		});
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				queue.add(new Edge(i, j, cost[i] + cost[j]));
			}
		}
		group = new int[n +1];
		for (int i =1; i<=n ; i++) {
			group[i] = i;
		}
		int ans = 0;
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			if (find(edge.u) != find(edge.v)) {
				ans += edge.w;
				merge(edge.u, edge.v);
			}
		}
		System.out.println(ans);
		scanner.close();
	}
}
