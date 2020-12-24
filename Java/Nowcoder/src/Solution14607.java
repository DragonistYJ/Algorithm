import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName 递推
 * @Author 11214
 * @Date 2020/4/2
 * @Description 快速幂
 */
public class Solution14607 {
    private static BigInteger MOD = new BigInteger("1000000009");

    private static BigInteger[][] unit() {
        BigInteger[][] base = new BigInteger[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                base[i][j] = new BigInteger("0");
            }
        }
        base[0][0] = new BigInteger("2");
        base[0][1] = new BigInteger("1");
        base[0][2] = new BigInteger("2");
        base[0][3] = new BigInteger("1");
        base[1][1] = new BigInteger("1");
        base[1][2] = new BigInteger("2");
        base[1][3] = new BigInteger("1");
        base[2][2] = new BigInteger("1");
        base[2][3] = new BigInteger("1");
        base[3][3] = new BigInteger("1");
        return base;
    }

    private static BigInteger[][] multi(BigInteger[][] A, BigInteger[][] B) {
        BigInteger[][] C = new BigInteger[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                C[i][j] = new BigInteger("0");
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    C[i][j] = C[i][j].add(A[i][k].multiply(B[k][j]).mod(MOD));
                }
            }
        }
        return C;
    }


    private static BigInteger[][] pow(long n) {
        BigInteger[][] ans = new BigInteger[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
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
        while (scanner.hasNext()) {
            BigInteger n = scanner.nextBigInteger();
            BigInteger[][] pow = pow(n.longValue());
            System.out.println(pow[0][3].mod(MOD).longValue());
        }
    }
}
