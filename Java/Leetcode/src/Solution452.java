import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 11214
 * @since 2022/11/21 9:49
 * <p>
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points
 * 其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球
 * 你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。
 * 可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 */
public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        List<List<Long>> pointList = new ArrayList<>();
        for (int[] point : points) {
            pointList.add(new ArrayList<>(Arrays.asList((long) point[0], (long) point[1])));
        }
        pointList.sort((o1, o2) -> {
            if (o1.get(1).equals(o2.get(1))) {
                return o1.get(0).compareTo(o2.get(0));
            } else {
                return o1.get(1).compareTo(o2.get(1));
            }
        });

        int ans = 0;
        int i = 0;
        while (i < pointList.size()) {
            ans += 1;
            int j = i + 1;
            while (j < pointList.size() && pointList.get(j).get(0) <= pointList.get(i).get(1)) {
                j += 1;
            }
            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
        System.out.println(new Solution452().findMinArrowShots(points));
    }
}
