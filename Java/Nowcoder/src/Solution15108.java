import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @problem 道路建设
 * @author 11214
 * @category 最小生成树
 * @description 随着如今社会的不断变化，交通问题也变得越来越重要，所以市长决定建设一些公路来方便各个城市之间的贸易和交易。
 *              虽然市长的想法很好，但是他也遇到了一般人也经常头疼的问题，那就是手头的经费有限……在规划过程中，设计师们已经预算出部分城市之间建设公路的经费需求。
 *              现在市长想知道，它能不能将他的m个城市在有限的经费内实现公路交通。如果可以的话，输出Yes，否则输出No（两个城市不一定要直接的公路相连，间接公路到达也可以。）
 */
public class Solution15108 {
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
		while (scanner.hasNext()) {
			int c = scanner.nextInt();
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			Queue<Edge> queue = new PriorityQueue<>((e1, e2) -> {
				return Integer.compare(e1.w, e2.w);
			});
			for (int i = 0; i < n; i++) {
				int u = scanner.nextInt();
				int v = scanner.nextInt();
				int w = scanner.nextInt();
				queue.add(new Edge(u, v, w));
			}
			group = new int[m + 1];
			for (int i = 0; i <= m; i++) {
				group[i] = i;
			}
			int sum = 0;
			while (!queue.isEmpty()) {
				Edge edge = queue.poll();
				if (find(edge.u) != find(edge.v)) {
					sum += edge.w;
					merge(edge.u, edge.v);
				}
			}
			if (c >= sum)
				System.out.println("Yes");
			else
				System.out.println("No");
		}

		scanner.close();
	}
}
