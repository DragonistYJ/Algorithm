import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yujian
 * @since 2022/9/6 10:35
 * 给你一个数组points，其中points[i] = [xi, yi]，表示第i个点在二维平面上的坐标。多个点可能会有相同的坐标。
 * 同时给你一个数组queries，其中queries[j] = [xj, yj, rj]，表示一个圆心在(xj, yj)且半径为rj的圆。
 * 对于每一个查询queries[j]，计算在第j个圆内点的数目。如果一个点在圆的边界上，我们同样认为它在圆内。
 * 请你返回一个数组answer，其中answer[j]是第j个查询的答案。
 */
public class Solution1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            for (int[] point : points) {
                if (point[0] < query[0] - query[2] || point[1] < query[1] - query[2] || point[1] > query[1] + query[2]) {
                    continue;
                }
                if (point[0] > query[0] + query[2]) {
                    break;
                }
                if ((point[0] - query[0]) * (point[0] - query[0]) + (point[1] - query[1]) * (point[1] - query[1]) <= query[2] * query[2]) {
                    ans[i] += 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1828().countPoints(
                new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}},
                new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}}
        )));
    }
}
