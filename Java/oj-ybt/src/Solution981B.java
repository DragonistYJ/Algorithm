import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/3/4 21:54
 */
public class Solution981B {
    private static long m;
    private static final long[][] EIG = new long[][]{{1, 0}, {0, 1}};

    public static long[][] matmul(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    C[i][j] = (C[i][j] % m + (A[i][k] * B[k][j]) % m) % m;
                }
            }
        }
        return C;
    }

    public static long[][] fastPow(long[][] matrix, long n) {
        if (n == 1) {
            return matrix;
        }
        long[][] base = n % 2 == 1 ? matrix : EIG;
        long[][] res = fastPow(matrix, n / 2);
        return matmul(matmul(base, res), res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        m = sc.nextLong();
        if (m <= 2) {
            System.out.println(1);
            return;
        }
        long[][] res = fastPow(new long[][]{{1, 1}, {1, 0}}, n - 2);
        System.out.println((res[0][0] + res[0][1]) % m);
    }
}
