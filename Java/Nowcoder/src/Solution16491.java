import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/1/6 14:30
 */
public class Solution16491 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '*') {
                    System.out.print("*");
                } else {
                    int sum = 0;
                    for (int[] direction : directions) {
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '*') {
                            sum += 1;
                        }
                    }
                    System.out.print(sum);
                }
            }
            System.out.println();
        }
    }
}
