import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @problem 最短路
 * @author 11214
 * @category 最短路
 * @description 给定一个有n个顶点（从1到n编号），m条边的有向图（其中某些边权可能为负，但保证没有负环）。请你计算从1号点到其他点的最短路。
 */
public class Solution14369 {
	private static class Edge {
		private int v;
		private long w;

		public Edge(int v, long w) {
			this.v = v;
			this.w = w;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		List<List<Edge>> graph = new ArrayList<>();
		for (int i =0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i=0; i<m; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			long w = scanner.nextLong();
			graph.get(u).add(new Edge(v, w));
		}
		long[] dist = new long[n+1];
		Arrays.fill(dist, 2000000000);
		dist[1] = 0;
		Queue<Edge> queue = new PriorityQueue<>((e1, e2) -> {
			return Long.compare(e1.w, e2.w);
		});
		queue.add(new Edge(1, 0));
		while (!queue.isEmpty()) {
			int v = queue.poll().v;
			List<Edge> edges = graph.get(v);
			for (Edge edge: edges) {
				if (dist[v] + edge.w < dist[edge.v]) {
					dist[edge.v] = dist[v] + edge.w;
					queue.add(new Edge(edge.v, dist[edge.v]));
				}
			}
		}
		for (int i=2; i<=n; i++) {
			System.out.println(dist[i]);
		}
	}
}
