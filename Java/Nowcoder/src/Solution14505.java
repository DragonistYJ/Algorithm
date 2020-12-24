import java.util.List;
import java.util.Scanner;

/**
 * @ClassName 轰炸区最优选取
 * @Author 11214
 * @Date 2020/4/3
 * @Description DFS
 */
public class Solution14505 {
    private static int[][] matrix;

    private static int sum(int x, int y, int k) {
        int sum = 0;
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        matrix = new int[50][50];
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int ans = 0;
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    ans = Math.max(ans, sum(i, j, k));
                }
            }
            System.out.println(ans);
        }
    }
}
