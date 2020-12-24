/*
NO807 保持城市天际线
在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。
最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。
建筑物高度可以增加的最大总和是多少？
 */
public class Solution807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] col = new int[m];
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            row[i] = grid[i][0];
            for (int j = 1; j < m; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            col[i] = grid[0][i];
            for (int j = 0; j < n; j++) {
                col[i] = Math.max(col[i], grid[j][i]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += Math.min(row[i], col[j]) - grid[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
