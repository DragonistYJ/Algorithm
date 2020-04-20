import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName Solution15666
 * @Author 11214
 * @Date 2020/4/2
 * @Description TODO
 */
public class Solution15666 {
    private static BigInteger MOD = new BigInteger("1000000007");

    private static BigInteger[][] unit() {
        BigInteger[][] unit = new BigInteger[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                unit[i][j] = new BigInteger("0");
            }
        }
        unit[0][0] = new BigInteger("1");
        unit[0][1] = new BigInteger("1");
        unit[0][2] = new BigInteger("1");
        unit[0][3] = new BigInteger("4");
        unit[0][4] = new BigInteger("6");
        unit[0][5] = new BigInteger("4");
        unit[1][0] = new BigInteger("1");
        unit[2][2] = new BigInteger("1");
        unit[2][3] = new BigInteger("3");
        unit[2][4] = new BigInteger("3");
        unit[2][5] = new BigInteger("1");
        unit[3][3] = new BigInteger("1");
        unit[3][4] = new BigInteger("2");
        unit[3][5] = new BigInteger("1");
        unit[4][4] = new BigInteger("1");
        unit[4][5] = new BigInteger("1");
        unit[5][5] = new BigInteger("1");
        return unit;
    }

    private static BigInteger[][] multi(BigInteger[][] A, BigInteger[][] B) {
        BigInteger[][] C = new BigInteger[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                C[i][j] = new BigInteger("0");
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    C[i][j] = C[i][j].add(A[i][k].multiply(B[k][j])).mod(MOD);
                }
            }
        }
        return C;
    }

    private static BigInteger[][] pow(long n) {
        BigInteger[][] ans = new BigInteger[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == j) ans[i][j] = new BigInteger("1");
                else ans[i][j] = new BigInteger("0");
            }
        }
        BigInteger[][] base = unit();
        while (n != 0) {
            if (n % 2 == 1) ans = multi(ans, base);
            base = multi(base, base);
            n = n / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            long f = scanner.nextLong();
            BigInteger[][] pow = pow(f - 1);
            System.out.println(pow[0][0].add(pow[0][2]).add(pow[0][3]).add(pow[0][4]).add(pow[0][5]).mod(MOD).longValue());
        }
    }
}
