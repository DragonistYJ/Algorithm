import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @problem 车站分级
 * @author 11214
 * @category 图论
 * @description 一条单向的铁路线上，依次有编号为1, 2, …, n 的n 个火车站。每个火车站都有一个级别，最低为1 级。
 *              现有若干趟车次在这条线路上行驶，每一趟都满足如下要求：如果这趟车次停靠了火车站x，则始发站、终点站之间所有级别大于等于火车站x
 *              的都必须停靠。 （注意：起始站和终点站自然也算作事先已知需要停靠的站点）
 */
public class Solution16541 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[][] connection = new boolean[n][n];
        int[] inDegree = new int[n];
        HashSet<Integer> waits = new HashSet<>(n);
        for (int i = 0; i < m; i++) {
            waits.clear();
            int s = scanner.nextInt();
            int min = Integer.MAX_VALUE;
            int max = 0;
            min = scanner.nextInt() - 1;
            for (int j = 1; j < s - 1; j++) {
                waits.add(scanner.nextInt() - 1);
            }
            max = scanner.nextInt() - 1;
            waits.add(min);
            waits.add(max);
            for (int j = min; j <= max; j++) {
                if (!waits.contains(j)) {
                    for (Integer wait : waits) {
                        connection[j][wait] = true;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (connection[i][j]) {
                    inDegree[j] += 1;
                }
            }
        }
 
        int step = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        List<Integer> temp= new ArrayList<>(n);
        while (!queue.isEmpty()) {
            step += 1;
            temp.clear();
            while (!queue.isEmpty()) {
                Integer station = queue.poll();
                for (int i = 0; i < n; i++) {
                    if (connection[station][i]) {
                        inDegree[i] -= 1;
                        if (inDegree[i] == 0) {
                            temp.add(i);
                        }
                    }
                }
            }
            queue.addAll(temp);
        }
 
        System.out.println(step);
 
        scanner.close();
	}
}
