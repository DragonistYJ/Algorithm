import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @problem 迷宫2
 * @author 11214
 * @category 最短路
 * @description 这是一个关于二维格子状迷宫的题目。迷宫的大小为N*M，左上角格子座标为(1,1)、右上角格子座标为(1,M)、左下角格子座标为(N,1)、右下角格子座标为(N,M)。每一格都用-1到109之间的整数表示，意义分别为：-1为墙壁，0为走道，而1到109之间的正整数代表特殊的走道。
 *              蜥蜴最初位于迷宫的座标(1,1)的格子，每一步蜥蜴只能往上、下、左、右、左上、右上、左下、右下八个方向之一前进一格，并且，他也不能走出迷宫边界。蜥蜴的目的地是走到迷宫的右下角格子，也就是座标位置(N,M)。我们想要动一些手脚，使得蜥蜴没有办法从(1,1)出发并抵达(N,M)。我们学会了一个邪恶的法术，这个法术可以把特殊的走道变成墙壁，施法一次的代价为表示该特殊走道的正整数。
 *              假设，我们可以在蜥蜴出发之前不限次数的使用这个邪恶的法术，所花的总代价即为每次施法代价的总和，蜥蜴出发之后就不能再使用这个法术了，请问让蜥蜴没办法达到终点所必须花费的最小总代价是多少呢？
 *              注意，0所代表的走道是无法变为墙壁的。
 */
public class Solution15196 {
	private static class Node {
		private int x;
		private int y;
		private long cost;

		public Node(int x, int y, long cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		int q = scanner.nextInt();
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		long[][] quiz = new long[n][m];
		long[][] costs = new long[n][m];

		while (q-- > 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					quiz[i][j] = scanner.nextLong();
					costs[i][j] = 250000000000000l;
				}
			}
			Queue<Node> queue = new PriorityQueue<>((n1, n2) -> {
				return Long.compare(n1.cost, n2.cost);
			});

			for (int i = 1; i < n; i++) {
				if (quiz[i][0] == 0)
					continue;
				if (quiz[i][0] == -1) {
					queue.add(new Node(i, 0, 0));
					costs[i][0] = 0;
				} else {
					queue.add(new Node(i, 0, quiz[i][0]));
					costs[i][0] = quiz[i][0];
				}
			}
			for (int i = 1; i < m - 1; i++) {
				if (quiz[n - 1][i] == 0)
					continue;
				if (quiz[n - 1][i] == -1) {
					queue.add(new Node(n - 1, i, 0));
					costs[n - 1][i] = 0;
				} else {
					queue.add(new Node(n - 1, i, quiz[n - 1][i]));
					costs[n - 1][i] = quiz[n - 1][i];
				}
			}

			boolean flag = true;
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				if (node.x == 0 || node.y == m-1) {
					flag = false;
					System.out.println(node.cost);
					break;
				}
				for (int i = 0; i < 4; i++) {
					int x = node.x + directions[i][0];
					int y = node.y + directions[i][1];
					if (x >= 0 && x < n && y >= 0 && y < m && quiz[x][y] != 0) {
						long cost = node.cost;
						if (quiz[x][y] != -1)  {
							cost = node.cost + quiz[x][y];
						}
						if (cost < costs[x][y]) {
							costs[x][y] = cost;
							queue.add(new Node(x, y, cost));
						}
					}
				}
			}
			if (flag) {
				System.out.println(-1);
			}
		}
	}
}
