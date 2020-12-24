import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * @problem Travel
 * @author 11214
 * @category 最短路
 * @description 精灵王国有N座美丽的城市，它们以一个环形排列在Bzeroth的大陆上。其中第i座城市到第i+1座城市花费的时间为d[i]。特别地，第N座城市到第1座城市花费的时间为d[N]。这些道路都是双向的。
 *              另外，精灵们在数千年的时间里建造了M座传送门，第i座传送门连接了城市u[i]与城市v[i]，并且需要花费w[i]的时间通过（可能有两座传送门连接了同一对城市，也有可能一座传送门连接了相同的两座城市）。这些传送门都是双向的。
 *              小S是精灵王国交通部部长，她的职责是为精灵女王设计每年的巡查路线。每次陛下会从某一个城市到达另一个城市，沿路调查每个城市的治理情况，她需要找出一条用时最短的路线。
 */
public class Solution14292 {
	private static class Edge {
		private int toNode;
		private long dist;

		public Edge(int toNode, long dist) {
			this.toNode = toNode;
			this.dist = dist;
		}
	}
	
	private static int n = 0;
	private static List<List<Edge>> graph;
	private static HashMap<Integer, long[]> hashMap;

	private static void dijkstra(int start) {
		long MAX = Long.MAX_VALUE >> 4;
		long[] distance = new long[n+1];
		Arrays.fill(distance, MAX);
		Queue<Edge> queue = new PriorityQueue<>((o1, o2) -> {
			return Long.compare(o1.dist, o2.dist);
		});
		distance[start] = 0;

		queue.add(new Edge(start, start));
		while (!queue.isEmpty()) {
			int toNode = queue.poll().toNode;
			List<Edge> list = graph.get(toNode);
			for (Edge edge : list) {
				if (distance[toNode] + edge.dist <= distance[edge.toNode]) {
					distance[edge.toNode] = distance[toNode] + edge.dist;
					queue.add(new Edge(edge.toNode, distance[edge.toNode]));
				}
			}
		}
		hashMap.put(start, distance);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		int m = scanner.nextInt();
		long[] dist = new long[n + 1];
		graph = new ArrayList<>();
		hashMap = new HashMap<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 1; i <= n; i++) {
			dist[i] = scanner.nextLong();
			graph.get(i).add(new Edge(i % n + 1, dist[i]));
			graph.get(i % n + 1).add(new Edge(i, dist[i]));
		}
		for (int i = 1; i <= n; i++) {
			dist[i] = dist[i] + dist[i - 1];
		}
		Set<Integer> doors = new HashSet<>();
		for (int i = 1; i <= m; i++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			int w = scanner.nextInt();
			if (from == to)
				continue;
			doors.add(from);
			doors.add(to);
			graph.get(from).add(new Edge(to, w));
			graph.get(to).add(new Edge(from, w));
		}
		for (Integer door : doors) {
			dijkstra(door);
		}

		int q = scanner.nextInt();
		for (int i = 0; i < q; i++) {
			int s = scanner.nextInt();
			int t = scanner.nextInt();
			long len = Math.abs(dist[s - 1] - dist[t - 1]);
			long ans = Math.min(len, dist[n] - len);
			for (Integer door : doors) {
				long[] distance = hashMap.get(door);
				ans = Math.min(distance[s] + distance[t], ans);
			}
			System.out.println(ans);
		}
	}
}
