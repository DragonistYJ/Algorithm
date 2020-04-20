import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @problem 挖沟
 * @author 11214
 * @category 最小生成树
 * @description 胡队长带领HA实验的战士们玩真人CS，真人CS的地图由一些据点组成，现在胡队长已经占领了n个据点，为了方便，将他们编号为1-n，
 *              为了隐蔽，胡队长命令战士们在每个据点出挖一个坑，让战士们躲在坑里。
 *              由于需要在任意两个点之间传递信息，两个坑之间必须挖出至少一条通路，而挖沟是一件很麻烦的差事，所以胡队长希望挖出数量尽可能少的沟，
 *              使得任意两个据点之间有至少一条通路，顺便，尽可能的∑d[i][j]使最小（其中d[i][j]为据点i到j的距离）。
 */
public class Solution17509 {
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

	private static int find(int n, int[] group) {
		if (group[n] == n)
			return n;
		else {
			group[n] = find(group[n], group);
			return group[n];
		}
	}

	private static void merge(int n1, int n2, int[] group) {
		int g1 = find(n1, group);
		int g2 = find(n2, group);
		if (g1 != g2) {
			group[g1] = g2;
		}
	}

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
		list.sort((e1,e2) -> {
			return Integer.compare(e1.w, e2.w);
		});
		int[] group = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			group[i] = i;
		}
		int ans = 0;
		for (int i = 0; i < m; i++) {
			Edge edge = list.get(i);
			if (find(edge.u, group) != find(edge.v, group)) {
				ans += edge.w;
				merge(edge.u, edge.v, group);
			}
		}
		System.out.println(ans);
		scanner.close();
	}
}
