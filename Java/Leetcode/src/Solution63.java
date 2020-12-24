/*
NO63 不同路径2
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        int index = 0;
        while (index < n && obstacleGrid[0][index] != 1) {
            path[0][index] = 1;
            index += 1;
        }
        index = 0;
        while (index < m && obstacleGrid[index][0] != 1) {
            path[index][0] = 1;
            index += 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                } else {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }
        return path[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] x = {{0, 1, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(new Solution63().uniquePathsWithObstacles(x));
    }
}
