import java.util.Arrays;

/**
 * @author 11214
 * @since 2022/12/28 15:20
 * <p>
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。
 * 我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 */
public class Solution1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        while (start != destination) {
            sum += distance[start];
            start += 1;
            start %= distance.length;
        }
        int total = Arrays.stream(distance).sum();
        return Math.min(sum, total - sum);
    }
}
