import java.util.Scanner;

/**
 * @ClassName 螺旋矩阵
 * @Author 11214
 * @Date 2020/4/1
 * @Description 数学，暴力枚举
 */
public class Solution16502 {
    private static int circle(int row, int col, int n) {
        int a;
        if (row >= n / 2) a = n - row - 1;
        else a = row;
        int b;
        if (col >= n / 2) b = n - col - 1;
        else b = col;
        return Math.min(a, b) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int circle = circle(row - 1, col - 1, n);

        int sum = 0;
        int m = n;
        for (int i = 1; i < circle; i++) {
            sum += m * 4 - 4;
            m -= 2;
        }

        if (row == circle) {
            sum += col - circle + 1;
        } else if (col == n - circle + 1) {
            sum += m;
            sum += row - circle;
        } else if (row == n - circle + 1) {
            sum += 2 * m - 1;
            sum += n - col - circle + 1;
        } else {
            sum += 3 * m - 2;
            sum += n - row - circle + 1;
        }

        System.out.println(sum);
    }
}
