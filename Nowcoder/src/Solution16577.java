import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @problem 文化之旅
 * @author 11214
 * @category 图论
 * @description 有一位使者要游历各国，他每到一个国家，都能学到一种文化，但他不愿意学习任何一种文化超过一次
 *              （即如果他学习了某种文化，则他就不能到达其他有这种文化的国家）。不同的国家可能有相同的文化。
 *              不同文化的国家对其他文化的看法不同，有些文化会排斥外来文化（即如果他学习了某种文化，则他不能到达排斥这种文化的其他国家）。
 *              现给定各个国家间的地理关系，各个国家的文化，每种文化对其他文化的看法，以及这位使者游历的起点和终点（在起点和终点也会学习当地的文化），
 *              国家间的道路距离，试求从起点到终点最少需走多少路。
 */
public class Solution16577 {
	private static int n; // 国家数量
	private static int k; // 文化数量
	private static int m; // 道路数量
	private static int s;
	private static int t;
	private static int[][] graph;
	private static int[][] exclusions;
	private static int[] caltures;
	private static HashSet<Integer> learned;
	private static boolean[] visited;
	private static int ans;

	private static void dfs(int country, int cost) {
		if (country == t) {
			ans = Math.min(ans, cost);
			return;
		}
		if (cost >= ans)
			return;

		for (int i = 0; i < n; i++) {
			if (visited[i] || graph[country][i] == Integer.MAX_VALUE)
				continue;
			int calture = caltures[i];
			if (learned.contains(calture))
				continue;
			boolean flag = false;
			for (Integer learn : learned) {
				if (exclusions[calture][learn] == 1) {
					flag = true;
					break;
				}
			}
			if (flag)
				continue;

			visited[i] = true;
			learned.add(calture);
			dfs(i, cost + graph[country][i]);
			learned.remove(calture);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		m = scanner.nextInt();
		s = scanner.nextInt() - 1;
		t = scanner.nextInt() - 1;
		caltures = new int[n];
		visited = new boolean[n];
		graph = new int[n][n];
		learned = new HashSet<>(k);
		for (int i = 0; i < n; i++) {
			caltures[i] = scanner.nextInt() - 1;
		}
		exclusions = new int[k][k];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				exclusions[i][j] = scanner.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE >> 2);
		}
		for (int i = 0; i < m; i++) {
			int u = scanner.nextInt() - 1;
			int v = scanner.nextInt() - 1;
			int w = scanner.nextInt();
			if (u == v)
				continue;
			if (exclusions[caltures[v]][caltures[u]] != 1) {
				graph[u][v] = Math.min(graph[u][v], w);
			}
			if (exclusions[caltures[u]][caltures[v]] != 1) {
				graph[v][u] = Math.min(graph[v][u], w);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		if (graph[s][t] == Integer.MAX_VALUE >> 2) {
			System.out.println(-1);
		} else {
			System.out.println(graph[s][t]);
		}

//		ans = Integer.MAX_VALUE;
//		visited[s] = true;
//		learned.add(caltures[s]);
//		dfs(s, 0);

//		if (ans == Integer.MAX_VALUE) {
//			System.out.println(-1);
//		} else {
//			System.out.println(ans);
//		}

		scanner.close();
	}
}
