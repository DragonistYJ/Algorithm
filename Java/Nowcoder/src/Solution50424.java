import java.util.Scanner;

/**
 * @problem 太鼓达人
 * @author 11214
 * @category 欧拉回路
 * @description 七夕祭上，Vani牵着cl的手，在明亮的灯光和欢乐的气氛中愉快地穿行。这时，在前面忽然出现了一台太鼓达人机台，而在机台前坐着的是刚刚被精英队伍成员XLk、Poet_shy和lydrainbowcat拯救出来的的applepi。
 *              看到两人对太鼓达人产生了兴趣，applepi果断闪人，于是cl拿起鼓棒准备挑战。然而即使是在普通难度下，cl的路人本性也充分地暴露了出来。
 *              一曲终了，不但没有过关，就连鼓都不灵了。Vani十分过意不去，决定帮助工作人员修鼓。
 *              鼓的主要元件是M个围成一圈的传感器。每个传感器都有开和关两种工作状态，分别用1和0表示。
 *              显然，从不同的位置出发沿顺时针方向连续检查K个传感器可以得到M个长度为K的01串。Vani知道这M个01串应该是互不相同的。而且鼓的设计很精密，M会取到可能的最大值。
 *              现在Vani已经了解到了K的值，他希望你求出M的值，并给出字典序最小的传感器排布方案。
 */
public class Solution50424 {
	private static boolean[] visited;
	private static int[] ans;
	private static int m;

	private static boolean dfs(int n, int step) {
		if (visited[n])
			return false;
		if (step == m)
			return true;
		visited[n] = true;
		ans[step] = n & 1;
		int next = (n << 1) & (m - 1);
		if (dfs(next, step + 1) || dfs(next | 1, step + 1)) {
			return true;
		}
		visited[n] = false;
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		m = 1 << k;
		visited = new boolean[m];
		ans = new int[m];
		dfs(0, 1);
		System.out.print(m + " ");
		for (int i = 1; i < k; i++) {
			System.out.print(0);
		}
		for (int i = 1; i <= m - k + 1; i++) {
			System.out.print(ans[i]);
		}
		scanner.close();
	}
}
