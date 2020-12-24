import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @problem 信息传递
 * @author 11214
 * @category 图论
 * @description 有 n 个同学（编号为 1 到 n）正在玩一个信息传递的游戏。在游戏里每人都有一个固定的信息传递对象，其中，编号为 i
 *              的同学的信息传递对象是编号为Ti的同学。
 *              游戏开始时，每人都只知道自己的生日。之后每一轮中，所有人会同时将自己当前所知的生日信息告诉各自的信息传递对象（注意：可能有人可以从若干人那里获取信息，
 *              但是每人只会把信息告诉一个人，即自己的信息传递对象）。当有人从别人口中得知自己的生日时，游戏结束。请问该游戏一共可以进行几轮?
 */
public class Solution16466 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> people = new ArrayList<>(n + 1);
		people.add(0);
		for (int i = 0; i < n; i++) {
			people.add(scanner.nextInt());
		}
		int ans = Integer.MAX_VALUE;
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (visited[i])
				continue;
			int tmp = i;
			boolean flag = false;
			List<Integer> path = new ArrayList<>();
			Set<Integer> circle = new HashSet<>();
			while (!circle.contains(tmp)) {
				if (visited[tmp]) {
					flag = true;
					break;
				}
				path.add(tmp);
				circle.add(tmp);
				tmp = people.get(tmp);
			}
			if (flag) continue;
			int index = 0;
			while (index < path.size() && path.get(index) != tmp)
				index += 1;
			ans = Math.min(ans, path.size() - index);
			for (Integer node : circle) {
				visited[node] = true;
			}
		}
		System.out.println(ans);
		scanner.close();
	}
}
