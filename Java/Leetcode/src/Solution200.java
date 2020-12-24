import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
NO200 岛屿数量
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
你可以假设网格的四个边均被水包围。
 */
public class Solution200 {
    int n;
    int m;
    boolean[][] seeked;

    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        if (m == 0) return 0;
        int ans = 0;

        seeked = new boolean[n][m];
        int index = 0;
        while (index < n * m) {
            int row = index / m;
            int col = index % m;
            if (grid[row][col] == '0' || seeked[row][col]) {
                index += 1;
                continue;
            }
            ans += 1;
            seeked[row][col] = true;
            List<Integer> islands = new LinkedList<>();
            islands.add(index);
            while (!islands.isEmpty()) {
                Integer start = islands.get(0);
                islands.remove(0);
                seek(start, islands, grid);
            }
            index += 1;
        }

        return ans;
    }

    private void seek(int start, List<Integer> islands, char[][] grid) {
        int row = start / m;
        int col = start % m;
        if (row > 0 && !seeked[row - 1][col]) {
            seeked[row - 1][col] = true;
            if (grid[row - 1][col] == '1') islands.add((row - 1) * m + col);
        }
        if (row < n - 1 && !seeked[row + 1][col]) {
            seeked[row + 1][col] = true;
            if (grid[row + 1][col] == '1') islands.add((row + 1) * m + col);
        }
        if (col > 0 && !seeked[row][col - 1]) {
            seeked[row][col - 1] = true;
            if (grid[row][col - 1] == '1') islands.add(row * m + col - 1);
        }
        if (col < m - 1 && !seeked[row][col + 1]) {
            seeked[row][col + 1] = true;
            if (grid[row][col + 1] == '1') islands.add(row * m + col + 1);
        }
    }

    public static void main(String[] args) {
        char[][] x = {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(new Solution200().numIslands(x));
    }
}
