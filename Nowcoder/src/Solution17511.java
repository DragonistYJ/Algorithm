import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @problem 公交线路
 * @author 11214
 * @category 最短路
 * @description P市有n个公交站，之间连接着m条道路。P市计划新开设一条公交线路，该线路从城市的东站（s点）修建到西站（t点），请为P市设计一条满足上述条件并且最短的公交线路图。
 */
public class Solution17511 {
	private static class Edge {
		private int to;
		private long w;
		
		public Edge(int to, long w) {
			this.to = to;
			this.w = w;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int s = scanner.nextInt();
		int t = scanner.nextInt();
		List<List<Edge>> graph = new ArrayList<>();
		for (int i =0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i< m; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			long w = scanner.nextLong();
			graph.get(u).add(new Edge(v, w));
			graph.get(v).add(new Edge(u, w));
		}
		
		long[] dist = new long[n+1];
		Arrays.fill(dist, 10000001);
		dist[s] = 0;
		Queue<Edge> queue = new PriorityQueue<>((e1,e2) -> {
			return Long.compare(e1.w, e2.w);
		});
		queue.add(new Edge(s, 0));
		while (!queue.isEmpty()) {
			int u = queue.poll().to;
			List<Edge> edges = graph.get(u);
			for (Edge edge : edges) {
				if (dist[u] + edge.w < dist[edge.to]) {
					dist[edge.to] = dist[u] + edge.w;
					queue.add(new Edge(edge.to, dist[edge.to]));
				}
			}
		}
		if (dist[t] == 10000001) System.out.println(-1);
		else System.out.println(dist[t]);
	}
}
