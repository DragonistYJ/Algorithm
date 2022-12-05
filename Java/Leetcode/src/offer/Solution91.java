package offer;

/**
 * @author 11214
 * @since 2022/12/5 16:14
 * <p>
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * 请计算出粉刷完所有房子最少的花费成本。
 */
public class Solution91 {
    public int minCost(int[][] costs) {
        int[] pre = new int[3];
        int[] ans = new int[3];

        pre[0] = costs[0][0];
        pre[1] = costs[0][1];
        pre[2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            ans[0] = Math.min(pre[1], pre[2]) + costs[i][0];
            ans[1] = Math.min(pre[0], pre[2]) + costs[i][1];
            ans[2] = Math.min(pre[0], pre[1]) + costs[i][2];

            System.arraycopy(ans, 0, pre, 0, 3);
        }
        return Math.min(Math.min(pre[0], pre[1]), pre[2]);
    }

    public static void main(String[] args) {
        int[][] costs = new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(new Solution91().minCost(costs));
    }
}
