import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName 洋灰三角
 * @Author 11214
 * @Date 2020/4/2
 * @Description 快速幂
 */
public class Solution17510 {
    private static BigInteger MOD = new BigInteger("1000000007");

    private static BigInteger[][] unit(long k, long p) {
        BigInteger[][] unit = new BigInteger[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                unit[i][j] = BigInteger.ZERO;
            }
        }
        unit[0][0] = new BigInteger(String.valueOf(k));
        unit[0][2] = new BigInteger(String.valueOf(p));
        unit[1][0] = BigInteger.ONE;
        unit[1][1] = BigInteger.ONE;
        unit[2][2] = BigInteger.ONE;
        return unit;
    }

    private static BigInteger[][] multi(BigInteger[][] A, BigInteger[][] B) {
        BigInteger[][] C = new BigInteger[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                C[i][j] = BigInteger.ZERO;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    C[i][j] = C[i][j].add(A[i][k].multiply(B[k][j])).mod(MOD);
                }
            }
        }
        return C;
    }

    private static BigInteger[][] pow(long n, long k, long p) {
        BigInteger[][] ans = new BigInteger[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ans[i][j] = i == j ? BigInteger.ONE : BigInteger.ZERO;
            }
        }
        BigInteger[][] unit = unit(k, p);
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
        BigInteger k = scanner.nextBigInteger();
        BigInteger p = scanner.nextBigInteger();

        BigInteger a1 = BigInteger.ONE;
        BigInteger a2 = a1.multiply(k).add(p);
        BigInteger a3 = a2.multiply(k).add(p);
        if (n.longValue() == 1) {
            System.out.println(1);
            return;
        } else if (n.longValue() == 2) {
            System.out.println(a1.add(a2).mod(MOD).longValue());
            return;
        }

        BigInteger[][] pow = pow(n.longValue() - 2, k.longValue(), p.longValue());
        System.out.println(pow[1][0].multiply(a3).mod(MOD)
                .add(pow[1][1].multiply(a2.add(BigInteger.ONE)).mod(MOD))
                .add(pow[1][2]).mod(MOD).longValue());
    }
}
