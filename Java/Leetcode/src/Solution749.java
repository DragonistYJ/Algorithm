import java.util.*;

/**
 * @ClassName Solution749
 * @Author 11214
 * @Date 2020/6/7
 * @Description 隔离病毒
 * 病毒扩散得很快，现在你的任务是尽可能地通过安装防火墙来隔离病毒。
 * 假设世界由二维矩阵组成，0 表示该区域未感染病毒，而 1 表示该区域已感染病毒。可以在任意 2 个四方向相邻单元之间的共享边界上安装一个防火墙（并且只有一个防火墙）。
 * 每天晚上，病毒会从被感染区域向相邻未感染区域扩散，除非被防火墙隔离。现由于资源有限，每天你只能安装一系列防火墙来隔离其中一个被病毒感染的区域（一个区域或连续的一片区域），且该感染区域对未感染区域的威胁最大且保证唯一。
 * 你需要努力使得最后有部分区域不被病毒感染，如果可以成功，那么返回需要使用的防火墙个数; 如果无法实现，则返回在世界被病毒全部感染时已安装的防火墙个数。
 */
public class Solution749 {
    private int n;
    private int m;
    private int[][] grid;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][][][] walls;

    private class Point {
        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Area {
        HashSet<Point> points;
        int threat;

        void setThreat() {
            HashSet<Point> points = new HashSet<>();
            for (Point point : this.points) {
                for (int i = 0; i < 4; i++) {
                    int x = point.x + directions[i][0];
                    int y = point.y + directions[i][1];
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0) points.add(new Point(x, y));
                }
            }
            this.threat = points.size();
        }

        void spread() {
            HashSet<Point> points = new HashSet<>();
            for (Point point : this.points) {
                for (int i = 0; i < 4; i++) {
                    int x = point.x + directions[i][0];
                    int y = point.y + directions[i][1];
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0
                            && !walls[point.x][point.y][x][y]
                            && !walls[x][y][point.x][point.y]) {
                        grid[x][y] = 1;
                        points.add(new Point(x, y));
                    }
                }
            }
            this.points.addAll(points);
            this.setThreat();
        }

        int constructWalls() {
            int sum = 0;
            for (Point point : this.points) {
                for (int i = 0; i < 4; i++) {
                    int x = point.x + directions[i][0];
                    int y = point.y + directions[i][1];
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0
                            && !walls[point.x][point.y][x][y]
                            && !walls[x][y][point.x][point.y]) {
                        sum += 1;
                        walls[point.x][point.y][x][y] = true;
                        walls[x][y][point.x][point.y] = true;
                    }
                }
            }
            return sum;
        }
    }

    private void dfs(int[][] grid, int x, int y, HashSet<Point> points) {
        points.add(new Point(x, y));
        for (int i = 0; i < 4; i++) {
            int xx = x + directions[i][0];
            int yy = y + directions[i][1];
            if (xx >= 0 && xx < n && yy >= 0 && yy < m && grid[xx][yy] == 1) {
                grid[xx][yy] = 0;
                dfs(grid, xx, yy, points);
            }
        }
    }

    public int containVirus(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
        walls = new boolean[n][m][n][m];
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (m >= 0) System.arraycopy(grid[i], 0, temp[i], 0, m);
        }
        List<Area> areas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 1) {

                }
            }
        }
        areas.sort(Comparator.comparingInt(o -> o.threat));

        int ans = 0;
        while (!areas.isEmpty()) {
            Area area = areas.get(areas.size() - 1);
            areas.remove(areas.size() - 1);
            ans += area.constructWalls();
            for (Area a : areas) a.spread();
            areas.sort(Comparator.comparingInt(o -> o.threat));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(new Solution749().containVirus(grid));
    }
}
