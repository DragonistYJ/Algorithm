/**
 * @author yujian
 * @since 2022/9/8 11:02
 * 给你一个二维整数数组 circles ，其中 circles[i] = [xi, yi, ri] 表示网格上圆心为 (xi, yi) 且半径为 ri 的第 i 个圆，返回出现在 至少一个 圆内的 格点数目 。
 * 注意：
 * 格点 是指整数坐标对应的点。
 * 圆周上的点 也被视为出现在圆内的点。
 */
public class Solution2249 {
    public int countLatticePoints(int[][] circles) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int[] circle : circles) {
            minX = Math.min(minX, circle[0] - circle[2]);
            minY = Math.min(minY, circle[1] - circle[2]);
            maxX = Math.max(maxX, circle[0] + circle[2]);
            maxY = Math.max(maxY, circle[1] + circle[2]);
        }
        int ans = 0;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                for (int[] circle : circles) {
                    if (Math.abs(i - circle[0]) * Math.abs(i - circle[0]) + Math.abs(j - circle[1]) * Math.abs(j - circle[1]) <= circle[2] * circle[2]) {
                        ans += 1;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2249().countLatticePoints(
                new int[][]{{2, 2, 1}}
        ));
    }
}
