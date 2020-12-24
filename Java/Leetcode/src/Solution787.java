import java.util.Arrays;

/*
NO787 K站中转最便宜的航班
有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 */
public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] route = new int[2][n];
        Arrays.fill(route[0], 1000000);
        Arrays.fill(route[1], 1000000);
        route[0][src] = 0;
        route[1][src] = 0;

        for (int i = 0; i <= K; i++) {
            for (int[] flight : flights) {
                route[i % 2][flight[1]] = Math.min(route[i % 2][flight[1]], route[(i + 1) % 2][flight[0]] + flight[2]);
            }
        }

        return route[K % 2][dst] == 1000000 ? -1 : route[K % 2][dst];
    }

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(new Solution787().findCheapestPrice(3, flights, 0, 2, 1));
    }
}