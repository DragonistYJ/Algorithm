import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName 选择颜色
 * @Author 11214
 * @Date 2020/4/2
 * @Description 快速幂
 */
public class Solution19115 {
    private static BigInteger MOD = new BigInteger("10007");

    private static BigInteger[][] unit(long c) {
        BigInteger[][] unit = new BigInteger[2][2];
        unit[0][0] = BigInteger.valueOf(c - 2);
        unit[0][1] = BigInteger.valueOf(c - 1);
        unit[1][0] = BigInteger.ONE;
        unit[1][1] = BigInteger.ZERO;
        return unit;
    }

    private static BigInteger[][] multi(BigInteger[][] A, BigInteger[][] B) {
        BigInteger[][] C = new BigInteger[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                C[i][j] = BigInteger.ZERO;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    C[i][j] = C[i][j].add(A[i][k].multiply(B[k][j])).mod(MOD);
                }
            }
        }
        return C;
    }

    private static BigInteger[][] pow(long n, long c) {
        BigInteger[][] ans = new BigInteger[2][2];
        ans[0][0] = BigInteger.ONE;
        ans[0][1] = BigInteger.ZERO;
        ans[1][0] = BigInteger.ZERO;
        ans[1][1] = BigInteger.ONE;
        BigInteger[][] unit = unit(c);
        while (n != 0) {
            if (n % 2 == 1) ans = multi(ans, unit);
            unit = multi(unit, unit);
            n = n / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        BigInteger c = scanner.nextBigInteger();
        BigInteger[][] pow = pow(n.longValue() - 2, c.longValue());
        System.out.println(pow[0][0].multiply(c).multiply(c.subtract(BigInteger.ONE)).mod(MOD).longValue());
    }
}
