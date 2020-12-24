import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @problem 聪明的猴子
 * @author 11214
 * @category 最小生成树
 * @description 在一个热带雨林中生存着一群猴子，它们以树上的果子为生。昨天下了一场大雨，现在雨过天晴，但整个雨林的地
 *              表还是被大水淹没着，部分植物的树冠露在水面上。猴子不会游泳，但跳跃能力比较强，它们仍然可以在露出水面
 *              的不同树冠上来回穿梭，以找到喜欢吃的果实。现在，在这个地区露出水面的有N棵树，假设每棵树本身的直径都
 *              很小，可以忽略不计。我们在这块区域上建立直角坐标系，则每一棵树的位置由其所对应的坐标表示(任意两棵树
 *              的坐标都不相同)。在这个地区住着的猴子有M个，下雨时，它们都躲到了茂密高大的树冠中，没有被大水冲走。由
 *              于各个猴子的年龄不同、身体素质不同，它们跳跃的能力不同。有的猴子跳跃的距离比较远(当然也可以跳到较近
 *              的树上)，而有些猴子跳跃的距离就比较近。这些猴子非常聪明，它们通过目测就可以准确地判断出自己能否跳到 对面的树上。 【问题】
 *              现已知猴子的数量及每一个猴子的最大跳跃距离，还知道露出水面的每一棵树的坐标，你
 *              的任务是统计有多少个猴子可以在这个地区露出水面的所有树冠上觅食。
 */
public class Solution19964 {
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
		int[] comprehances = new int[n];
		for (int i = 0; i < n; i++) {
			int w = scanner.nextInt();
			comprehances[i] = w * w;
		}
		int m = scanner.nextInt();
		group = new int[m + 1];
		for (int i = 0; i <= m; i++) {
			group[i] = i;
		}
		int[] xs = new int[m];
		int[] ys = new int[m];
		for (int i = 0; i < m; i++) {
			xs[i] = scanner.nextInt();
			ys[i] = scanner.nextInt();
		}
		Queue<Edge> queue = new PriorityQueue<>((e1, e2) -> {
			return Integer.compare(e1.w, e2.w);
		});
		for (int i = 0; i < m - 1; i++) {
			for (int j = i + 1; j < m; j++) {
				int distance = (xs[i] - xs[j]) * (xs[i] - xs[j]) + (ys[i] - ys[j]) * (ys[i] - ys[j]);
				queue.add(new Edge(i, j, distance));
			}
		}
		int max = 0;
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			if (find(edge.u) != find(edge.v)) {
				max = Math.max(max, edge.w);
				merge(edge.u, edge.v);
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (comprehances[i] >= max) {
				ans += 1;
			}
		}
		System.out.println(ans);

		scanner.close();
	}
}
