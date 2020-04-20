import java.util.Arrays;
import java.util.Scanner;

/**
 * @problem 最优乘车
 * @author 11214
 * @category 最短路
 * @description H城是一个旅游胜地，每年都有成千上万的人前来观光。为方便游客，巴士公司在各个旅游景点及宾馆，饭店等地都设置了巴士站并开通了一些单程巴上线路。每条单程巴士线路从某个巴士站出发，依次途经若干个巴士站，最终到达终点巴士站。
 *              一名旅客最近到H城旅游，他很想去S公园游玩，但如果从他所在的饭店没有一路已士可以直接到达S公园，则他可能要先乘某一路巴士坐几站，再下来换乘同一站台的另一路巴士,
 *              这样换乘几次后到达S公园。 现在用整数1,2,…N
 *              给H城的所有的巴士站编号，约定这名旅客所在饭店的巴士站编号为1…S公园巴士站的编号为N。
 *              写一个程序，帮助这名旅客寻找一个最优乘车方案,使他在从饭店乘车到S公园的过程中换车的次数最少。
 */
public class Solution16816 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.nextLine();
		long[][] graph = new long[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(graph[i], Long.MAX_VALUE >> 2);
			graph[i][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			String line = scanner.nextLine();
			String[] strings = line.split(" ");
			int[] ints = new int[strings.length];
			for (int j = 0; j < strings.length; j++) {
				ints[j] = Integer.parseInt(strings[j]);
			}
			for (int j = 0; j < strings.length; j++) {
				for (int k = j + 1; k < strings.length; k++) {
					graph[ints[j]][ints[k]] = 1;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		if (graph[1][n] == 1000000000)
			System.out.println("NO");
		else
			System.out.println(graph[1][n] - 1);
	}
}
/*
 * public class Solution16816 { private static class Line { private
 * List<Integer> list; private HashMap<Integer, Integer> hashMap;
 * 
 * public Line(List<Integer> list, HashMap<Integer, Integer> hashMap) {
 * this.list = list; this.hashMap = hashMap; } }
 * 
 * private static class Step { private int lineNumber; private int
 * stationNumber; private int length;
 * 
 * public Step(int lineNumebr, int stationNumber, int length) { this.lineNumber
 * = lineNumebr; this.stationNumber = stationNumber; this.length = length; } }
 * 
 * public static void main(String[] args) { Scanner scanner = new
 * Scanner(System.in); int m = scanner.nextInt(); int n = scanner.nextInt();
 * scanner.nextLine(); List<Line> lines = new ArrayList<>(); for (int i = 0; i <
 * m; i++) { String line = scanner.nextLine(); String[] strings =
 * line.split(" "); List<Integer> list = new ArrayList<>(); HashMap<Integer,
 * Integer> hashMap = new HashMap<>(); for (String s : strings) {
 * list.add(Integer.parseInt(s)); hashMap.put(Integer.parseInt(s), list.size() -
 * 1); } lines.add(new Line(list, hashMap)); }
 * 
 * Queue<Step> queue = new PriorityQueue<>((step1, step2) -> { return
 * step1.length - step2.length; }); for (int i = 0; i < lines.size(); i++) {
 * Line line = lines.get(i); if (line.hashMap.containsKey(1)) { int base =
 * line.hashMap.get(1); for (int j = base + 1; j< line.list.size(); j++) {
 * queue.add(new Step(i, line.list.get(j), 0)); } } } while (!queue.isEmpty()) {
 * Step step = queue.poll(); if (step.stationNumber == n) {
 * System.out.println(step.length); return; } for (int i = 0; i < lines.size();
 * i++) { Line line = lines.get(i); if (step.lineNumber == i ||
 * !line.hashMap.containsKey(step.stationNumber)) continue; int base =
 * line.hashMap.get(step.stationNumber); for (int j = base + 1; j <
 * line.list.size(); j++) { queue.add(new Step(i, line.list.get(j), step.length
 * +1)); } } } System.out.println("NO"); } }
 */
