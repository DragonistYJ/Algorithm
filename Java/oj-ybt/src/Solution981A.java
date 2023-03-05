import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/3/4 21:50
 */
public class Solution981A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }
        int p = sc.nextInt();
        int[][] matrix2 = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        int[][] ans = new int[n][p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < m; k++) {
                    ans[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
