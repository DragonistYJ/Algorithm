import java.util.ArrayList;
import java.util.List;

/**
 * @author yujian
 * @since 2022/9/9 10:09
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵heights，heights[r][c]表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * 返回网格坐标 result的 2D 列表 ，其中result[i] = [ri, ci]表示雨水从单元格 (ri, ci) 流动既可流向太平洋也可流向大西洋 。
 */
public class Solution417 {
    private void search(int[][] area, int[][] heights, int x, int y) {
        if (area[x][y] == 1) {
            return;
        }
        int n = heights.length;
        int m = heights[0].length;
        area[x][y] = 1;
        if (x + 1 < n && heights[x + 1][y] >= heights[x][y]) {
            search(area, heights, x + 1, y);
        }
        if (x - 1 >= 0 && heights[x - 1][y] >= heights[x][y]) {
            search(area, heights, x - 1, y);
        }
        if (y + 1 < m && heights[x][y + 1] >= heights[x][y]) {
            search(area, heights, x, y + 1);
        }
        if (y - 1 >= 0 && heights[x][y - 1] >= heights[x][y]) {
            search(area, heights, x, y - 1);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m];

        for (int i = 0; i < n; i++) {
            search(pacific, heights, i, 0);
            search(atlantic, heights, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            search(pacific, heights, 0, i);
            search(atlantic, heights, n - 1, i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> location = new ArrayList<>();
                    location.add(i);
                    location.add(j);
                    result.add(location);
                }
            }
        }
        return result;
    }
}
