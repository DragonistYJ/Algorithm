import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @problem 武
 * @author 11214
 * @category 最短路
 * @description 其次，Sεlιнα(Selina) 要进行体力比武竞赛。 在 Sεlιнα 所在的城市，有 NN 个街区，编号为 1 \sim
 *              N1∼N，总共有 N-1N−1 条的街道连接这些街区， 使得每两个街区之间都直接或间接地有街道将它们相连。Sεlιнα
 *              把通过了文化知识竞赛的参赛男友们召集到她家所在的街区 PP
 *              ，并以这个街区为起点，让所有参赛男友们向其他街区跑去。这些参赛者们被命令不准重复跑某条街道，而且在规定时间内要尽可能地跑远。比赛结束后，所有参赛者将停留在他们此时所在的街区。之后
 *              Sεlιнα 开始视察结果。现在她知道每个街区都有一些她的参赛男友停留着，她现在想先去看看离她家第 KK
 *              近的街区。所以作为一位好帮手，你的任务是要告诉她所有街区中，离 Sεlιнα 家第 KK 近的街区与 Sεlιнα
 *              家之间的距离。
 */
public class Solution15522 {
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
		int p = scanner.nextInt();
		int k = scanner.nextInt();
		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i<= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			long w = scanner.nextLong();
			graph.get(u).add(new Edge(v, w));
			graph.get(v).add(new Edge(u, w));
		}
		
		long[] dist = new long[n+1];
		Arrays.fill(dist, 200000000);
		dist[0] = 0;
		dist[p] = 0;
		Queue<Edge> queue = new PriorityQueue<>((e1,e2) -> {
			return Long.compare(e1.w, e2.w);
		});
		queue.add(new Edge(p, 0));
		while (!queue.isEmpty()) {
			int v = queue.poll().to;
			List<Edge> edges = graph.get(v);
			for (Edge edge : edges) {
				if (dist[v] + edge.w < dist[edge.to]) {
					dist[edge.to] = dist[v] + edge.w;
					queue.add(new Edge(edge.to, dist[edge.to]));
				}
			}
		}
		Arrays.sort(dist);
		System.out.println(dist[k+1]);
	}
}
