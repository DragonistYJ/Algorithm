import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/3/5 9:48
 */
public class Solution981C {
    private static long M;
    private static final long[][] E = new long[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

    private static long[][] matmul(long[][] A, long[][] B) {
        long[][] res = new long[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    res[i][j] = (res[i][j] + (A[i][k] * B[k][j]) % M) % M;
                }
            }
        }
        return res;
    }

    private static long[][] fastPow(long[][] A, long n) {
        if (n == 1) {
            return A;
        }
        long[][] base = n % 2 == 1 ? A : E;
        long[][] res = fastPow(A, n / 2);
        return matmul(matmul(base, res), res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        M = sc.nextLong();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }
        long[][] res = fastPow(new long[][]{{1, 1, 0}, {0, 1, 1}, {0, 1, 0}}, n - 2);
        System.out.println((res[0][0] * 2 + res[0][1] * 2 + res[0][2]) % M);
    }
}
